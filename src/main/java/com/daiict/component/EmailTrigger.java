package com.daiict.component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.hibernate.result.Output;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import com.daiict.model.EmailCfg;

@Component
public class EmailTrigger {

	@Autowired
	private JavaMailSender javaMailSender;
	private static int count;

//	private EmailCfg emailCfg;
//
//	public EmailTrigger(EmailCfg emailCfg) {
//		this.emailCfg = emailCfg;
//	}

//@Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
	@Scheduled(cron = "${cron.expression}")
	public void getEmail() {

		ArrayList<String> al = new ArrayList<String>();

		StringBuffer response = new StringBuffer();
		try {

			URL url = new URL("http://localhost:8080/review/student/getEmail");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				response.append(output);
			}
			br.close();
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		JSONArray jsonarray = new JSONArray(response.toString());
		for (int i = 0; i < jsonarray.length(); i++) {
			org.json.JSONObject jsonobject = jsonarray.getJSONObject(i);
			int id = (int) jsonobject.getInt("student_id");
			System.out.println("----> " + id);
//			al.add(id);
		}

		al.add("shahmohit9975@gmail.com");
		al.add("201812093@daiict.ac.in");
		al.add("201812021@daiict.ac.in");
		for (String email : al) {
			synchronized (this) {
				sendEmail(email);
			}
		}

	}

	void sendEmail(String emailId) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);
		msg.setSubject("Reminder For Write Your Internship Review");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
		System.out.println(new Date()+" \t"+emailId + " done -> " + count++);
		

	}

}
