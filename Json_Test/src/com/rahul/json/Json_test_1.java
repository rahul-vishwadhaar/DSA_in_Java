
package com.rahul.json;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * @author rahul kumar
 * 
 */
public class Json_test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONArray arr = new JSONArray();
		try {
			JSONObject obj1 = new JSONObject();
			obj1.put("NodeId", "NodeId_1");
			obj1.put("Value", new Integer(2));
			arr.put(obj1);
			JSONObject obj2 = new JSONObject();
			obj2.put("NodeId", "NodeId_2");
			obj2.put("Value", new Integer(4));
			arr.put(obj2);
			JSONObject obj3 = new JSONObject();
			obj3.put("NodeId", "NodeId_3");
			obj3.put("Value", new Integer(6));
			arr.put(obj3);
			JSONObject obj4 = new JSONObject();
			obj4.put("NodeId", "NodeId_4");
			obj4.put("Value", new Integer(9));
			arr.put(obj4);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(arr);

		testFunction(arr.toString());

	}

	private static void testFunction(String arr) {
		// TODO Auto-generated method stub

		System.out.println("Inside Test Function " + arr);
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(arr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < jsonArray.length(); i++) {
			try{
			JSONObject tempObj = (JSONObject) jsonArray.get(i);
			String nodeId = (String) tempObj.get("NodeId");
			Integer value = (Integer) tempObj.get("Value");
			System.out.println("NodeId : " + nodeId + " Value : " + value);
			}catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
	}

}
