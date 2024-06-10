package com.natgeo.auth0.api_components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joni.exception.ValueException;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * 
 *
 */
public class MailinatorApi {

	private final int MAX_ATTEMPTS = 100;
	private String tokenParam = "&token=ae81e934eeea444bb9c9d7f513aeb274";
	private String mailinatorApiUrl = "https://api.mailinator.com/api/";
	public Response response;
	public JsonPath jsonPathEvaluator;
	private static MailinatorApi instance = null;
	
	public static MailinatorApi getInstance() {
		if (instance == null) {
			instance = new MailinatorApi();
		}
		return instance;
	}

	/**
	 * Checks the mailbox of the email passed and returns the id of the user passed
	 * 
	 * @param email the email to check the inbox
	 * @return the id of the user passed
	 *
	 */
	public String FetchInbox(String email) throws Exception {
		response = RestAssured.get(mailinatorApiUrl + "inbox?to=" + email.replace("@mailinator.com", "") + tokenParam);
		ResponseBody<?> body = response.getBody();
		int i = 0;
		while (body.asString().isEmpty() && i < MAX_ATTEMPTS) {
			response = RestAssured
					.get(mailinatorApiUrl + "inbox?to=" + email.replace("@mailinator.com", "") + tokenParam);
			body = response.getBody();
			i++;
		}
		if (body.asString().isEmpty()) {
			throw new ValueException("Message was not found");
		}
		final JSONObject obj = new JSONObject(body.asString());
		final JSONArray geodata = obj.getJSONArray("messages");
		final JSONObject person = geodata.getJSONObject(0);
		return person.getString("id");
	}

	/**
	 * Returns the body of the first email in the mailbox
	 * 
	 * @param email body of the email to get the link
	 * @return the body of the first message in the inbox
	 *
	 */
	public String FetchEmail(String email) throws Exception {
		String fetch = this.FetchInbox(email);
		Response response = RestAssured.get(mailinatorApiUrl + "email?id=" + fetch + tokenParam);
		return response.getBody().asString();
	}

	/**
	 * Returns one link located on the email selected
	 * 
	 * @param email body of the email to get the link
	 * @return the URL located on the email
	 *
	 */
	public String GetEmailLink(String email) throws Exception {
		Pattern pattern = Pattern
				.compile("n            <a href=" + "\\" + "\\" + "\\" + "\"(.*?)" + "\\" + "\\" + "\\" + "\"");
		Matcher match = pattern.matcher(FetchEmail(email));
		match.find();
		return match.group(1);
	}

}
