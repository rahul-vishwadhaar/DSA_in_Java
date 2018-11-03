/*
 * Copyright (c) 2006 Rogério Liesenfeld
 * This file is subject to the terms of the MIT license (see LICENSE.txt).
 */
package mockit;

import java.util.concurrent.*;
import javax.sql.*;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.*;

import mockit.internal.*;

import org.w3c.dom.*;

public final class MockInstanceMatchingTest
{
   @Rule public final ExpectedException thrown = ExpectedException.none();

   static class Collaborator
   {
      private int value;
      int getValue() { return value; }
      void setValue(int value) { this.value = value; }
   }

   @Mocked Collaborator mock;

   @Test
   public void matchOnMockInstance(@Mocked Collaborator otherInstance)
   {
      new Expectations() {{ mock.getValue(); result = 12; }};

      int result = mock.getValue();
      assertEquals(12, result);

      Collaborator another = new Collaborator();
      assertEquals(0, another.getValue());
   }

   @Test
   public void recordOnMockInstanceButReplayOnDifferentInstance(@Mocked final Collaborator verifiedMock)
   {
      thrown.expect(MissingInvocation.class);

      new Expectations() {{ verifiedMock.getValue(); result = 12; }};

      Collaborator collaborator = new Collaborator();
      assertEquals(0, collaborator.getValue());
   }

   @Test
   public void verifyExpectationMatchingOnMockInstance(@Mocked final Collaborator verifiedMock)
   {
      new Collaborator().setValue(12);
      verifiedMock.setValue(12);

      new Verifications() {{ verifiedMock.setValue(12); times = 1; }};
   }

   @Test
   public void verifyExpectationsOnSameMethodCallForDifferentMockedInstances(@Mocked final Collaborator verifiedMock)
   {
      final Collaborator c1 = new Collaborator();
      c1.getValue();
      verifiedMock.getValue();
      final Collaborator c2 = new Collaborator();
      c2.getValue();

      new Verifications() {{
         verifiedMock.getValue(); times = 1;
         c1.getValue(); times = 1;
         c2.getValue(); times = 1;
      }};
   }

   @Test
   public void verifyOnMockInstanceButReplayOnDifferentInstance(@Mocked final Collaborator verifiedMock)
   {
      thrown.expect(MissingInvocation.class);

      new Collaborator().setValue(12);

      new Verifications() {{ verifiedMock.setValue(12); }};
   }

   @Test
   public void recordExpectationsMatchingOnMultipleMockInstances(@Mocked final Collaborator mock2)
   {
      new Expectations() {{
         mock.getValue(); result = 12;
         mock2.getValue(); result = 13;
         mock.setValue(20);
      }};

      assertEquals(12, mock.getValue());
      assertEquals(13, mock2.getValue());
      mock.setValue(20);
   }

   @Test
   public void recordOnSpecificMockInstancesButReplayOnDifferentOnes(@Mocked final Collaborator mock2)
   {
      thrown.expect(UnexpectedInvocation.class);

      new StrictExpectations() {{
         mock.setValue(12);
         mock2.setValue(13);
      }};

      mock2.setValue(12);
      mock.setValue(13);
   }

   @Test
   public void verifyExpectationsMatchingOnMultipleMockInstances(@Mocked final Collaborator mock2)
   {
      mock.setValue(12);
      mock2.setValue(13);
      mock.setValue(20);

      new VerificationsInOrder() {{
         mock.setValue(12);
         mock2.setValue(13);
         mock.setValue(20);
      }};
   }

   @Test
   public void verifyOnSpecificMockInstancesButReplayOnDifferentOnes(@Mocked final Collaborator mock2)
   {
      thrown.expect(MissingInvocation.class);

      mock2.setValue(12);
      mock.setValue(13);

      new FullVerifications() {{
         mock.setValue(12);
         mock2.setValue(13);
      }};
   }

   @Test
   public void matchOnTwoMockInstances(@Mocked final Collaborator mock2)
   {
      new Expectations() {{
         mock.getValue(); result = 1; times = 1;
         mock2.getValue(); result = 2; times = 1;
      }};

      assertEquals(1, mock.getValue());
      assertEquals(2, mock2.getValue());
   }

   @Test
   public void matchOnTwoMockInstancesAndReplayInDifferentOrder(@Mocked final Collaborator mock2)
   {
      new Expectations() {{
         mock.getValue(); result = 1;
         mock2.getValue(); result = 2;
      }};

      assertEquals(2, mock2.getValue());
      assertEquals(1, mock.getValue());
      assertEquals(1, mock.getValue());
      assertEquals(2, mock2.getValue());
   }

   @Test
   public void matchOnTwoMockInstancesForOtherwiseIdenticalExpectations(@Mocked final Collaborator mock2)
   {
      mock.getValue();
      mock2.getValue();
      mock2.setValue(1);
      mock.setValue(1);

      new Verifications() {{
         mock.getValue(); times = 1;
         mock2.getValue(); times = 1;
      }};

      new VerificationsInOrder() {{
         mock2.setValue(1);
         mock.setValue(1);
      }};
   }

   @Test
   public void recordExpectationsMatchingOnMultipleMockParametersButReplayOutOfOrder(
      @Mocked final Runnable r1, @Mocked final Runnable r2)
   {
      thrown.expect(UnexpectedInvocation.class);

      new StrictExpectations() {{
         r2.run();
         r1.run();
      }};

      r1.run();
      r2.run();
   }

   @Test
   public void verifyExpectationsMatchingOnMultipleMockParametersButReplayedOutOfOrder(
      @Mocked final AbstractExecutorService es1, @Mocked final AbstractExecutorService es2)
   {
      thrown.expect(MissingInvocation.class);

      es2.execute(null);
      es1.submit((Runnable) null);

      new FullVerificationsInOrder() {{
         es1.execute((Runnable) any);
         es2.submit((Runnable) any);
      }};
   }

   @Test
   public void recordExpectationMatchingOnInstanceCreatedInsideCodeUnderTest()
   {
      new Expectations() {{
         new Collaborator().getValue(); result = 1;
      }};

      assertEquals(1, new Collaborator().getValue());
   }

   @Test
   public void recordNonStrictExpectationsOnOneInstanceWhileStrictOnAnother(
      @Mocked final Collaborator mock1, @Mocked final Collaborator mock2)
   {
      new Expectations() {{ mock2.getValue(); result = 123; }};
      new StrictExpectations() {{ mock1.setValue(5); }};

      assertEquals(123, mock2.getValue());

      // mock1 is strict, mock2 is not
      mock1.setValue(5);
   }

   @Test
   public void recordExpectedConstructorInvocationForMockedTypeWithBothStrictAndNotStrictExpectations(
      @Mocked final Collaborator mock1, @Mocked final Collaborator mock2)
   {
      new Expectations() {{ mock1.getValue(); result = 123; }};

      new StrictExpectations() {{
         mock2.setValue(2);
         new Collaborator();
      }};

      mock2.setValue(2);
      new Collaborator();

      assertEquals(123, mock1.getValue());
   }

   @Test
   public void unexpectedConstructorInvocationForMockedTypeWithBothStrictAndNonStrictExpectations(
      @Mocked final Collaborator mock1, @Mocked final Collaborator mock2)
   {
      new Expectations() {{ mock1.getValue(); result = 1; }};
      new StrictExpectations() {{ mock2.getValue(); result = 2; }};

      assertEquals(1, mock1.getValue());
      assertEquals(2, mock2.getValue());

      try {
         new Collaborator();
         fail();
      }
      catch (UnexpectedInvocation ignore) {}
   }

   @Test
   public void recordExpectationsOnTwoInstancesOfSameMockedInterface(
      @Mocked final DataSource mockDS1, @Mocked final DataSource mockDS2, @Mocked Attr n) throws Exception
   {
      new Expectations() {{
         mockDS1.getLoginTimeout(); result = 1000;
         mockDS2.getLoginTimeout(); result = 2000;
      }};

      assertNotSame(mockDS1, mockDS2);
      assertEquals(1000, mockDS1.getLoginTimeout());
      assertEquals(2000, mockDS2.getLoginTimeout());
      mockDS2.setLoginTimeout(3000);

      new Verifications() {{ mockDS2.setLoginTimeout(anyInt); }};
   }

   static class BaseClass { final void doSomething() {} }
   static final class SubclassA extends BaseClass { void doSomethingElse() {} }
   static final class SubclassB extends BaseClass { void doSomethingElse() {} }

   @Test
   public void verifyingCallsOnSpecificInstancesOfDifferentSubclasses(
      @Mocked SubclassA anyA, @Mocked final SubclassA a, @Mocked final SubclassB anyB)
   {
      a.doSomething();
      new BaseClass().doSomething();
      anyB.doSomething();
      a.doSomethingElse();
      new SubclassA().doSomethingElse();
      anyB.doSomethingElse();

      new Verifications() {{
         a.doSomethingElse(); times = 1;
         anyB.doSomethingElse(); times = 1;
         a.doSomething(); times = 1;
         anyB.doSomething(); times = 1;
      }};
   }
}
