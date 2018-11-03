package com.fcs.feedback;

import java.util.ArrayList;
import java.util.List;

import com.fcs.database.FeedBackDataDB;
import com.fcs.database.dto.FeedbackData;
import com.fcs.utils.IOUtils;
import com.fcs.utils.Logger;

public class FeedBackDataContainer {

	private FeedBackDataDB bean = null;

	private int[] feedback = null;
	private ArrayList<String> questions = new ArrayList<String>();
	private String forUser;
	private String userId;

	private FeedBackDataDB feedbackDB = null;
	private List<FeedbackData> feedDataList = null;
	private int[] summarisedFeedData = null;

	private Exception lastException = null;

	public FeedBackDataContainer(String userId, String feedBackId) {
		this.userId = userId;
		init(feedBackId);
	}

	public FeedBackDataContainer(String userId) {
		this.userId = userId;
	}

	public void init() {

		bean = new FeedBackDataDB();
		bean.init();
		initQuestions();
		menu();

	}

	private void menu() {
		int input = -1;
		do {
			populateData();
			printFeedback();

			IOUtils.println("Save the data...Y/N");
			String response = IOUtils.getString();
			if ((response.equalsIgnoreCase("Y"))) {
				saveFeedback();
				input = 2;
			} else {
				IOUtils.println("1......Re-enter data");
				IOUtils.println("2......Leave");

				input = IOUtils.getInt();
			}
		} while (input != 2);

	}

	private void init(String feedBackId) {

		feedback = getExistingDataFromDB(feedBackId);
		init();
	}

	private void populateData() {

		int response = -1;
		if (feedback == null) {
			feedback = new int[5];
		}

		IOUtils.println("Enter User Id");
		forUser = IOUtils.getString();
		IOUtils.println("Enter the value in the range of 1 to 5");
		int index = 0;
		for (String question : questions) {
			IOUtils.println(question);
			IOUtils.println("Enter Response");
			response = IOUtils.getInt();
			while (!isResponseValid(response)) {
				response = IOUtils.getInt();
			}
			feedback[index] = response;
			index++;
		}

	}

	private boolean isResponseValid(int response) {
		if ((response >= 1) && (response <= 5))
			return true;

		IOUtils.println("Please enter a valid response");
		return false;
	}

	private void initQuestions() {
		for (int i = 0; i < 5; i++) {
			questions.add(new String("Question" + i));
		}

	}

	private boolean saveFeedback() {

		Logger.info("Svaing Data into DB");

		ValidateFeedbackData feedbackDataBuilder = new ValidateFeedbackData();
		feedbackDataBuilder.setFeedbackData(feedback);
		feedbackDataBuilder.setForUser(forUser);
		feedbackDataBuilder.setFromUser(userId);

		FeedbackData feedbackData = feedbackDataBuilder.build();

		if (feedbackData == null)
			return false;

		IOUtils.println(feedbackData.toString());

		if (bean.saveFeedBackDatainDB(feedbackData)) {
			return true;
		} else {
			setLastException(bean.getLastException());
			return false;
		}
	}

	private void printFeedback() {
		int index = 0;
		IOUtils.println("Your responses");

		for (String question : questions) {
			IOUtils.print(question);
			IOUtils.println("--------------------- " + feedback[index]);
			index++;
		}

	}

	private int[] getExistingDataFromDB(String feedBackId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	public boolean initDataFromDB() {
		feedbackDB = new FeedBackDataDB();

		feedDataList = feedbackDB.getFeedBackDatainDB(userId);

		if (feedDataList == null) {
			setLastException(feedbackDB.getLastException());
			return false;
		}

		setSummarisedFeedData(getSummariseData());

		return true;
	}

	private int[] getSummariseData() {

		int[] avgFeedData = new int[5];
		int rating = -1;
		int size = feedDataList.size();

		for (FeedbackData data : feedDataList) {

			IOUtils.println(data.toString());
			rating = Integer.parseInt(data.getfeedbackData());

			for (int i = 4; i >= 0; i--) {
				avgFeedData[i] = avgFeedData[i] + rating % 10;
				rating = rating / 10;
			}
		}

		for (int i = 0; i < 5; i++) {
			avgFeedData[i] = avgFeedData[i] / size;
		}

		return avgFeedData;

	}

	public int[] getSummarisedFeedData() {
		return summarisedFeedData;
	}

	private void setSummarisedFeedData(int[] summarisedFeedData) {
		this.summarisedFeedData = summarisedFeedData;
	}
}
