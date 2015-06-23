package com.dao;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vo.Weather;

public class TMModel_Weather {
	
	public ArrayList<Weather> parse_wearher() {
		ArrayList<Weather> w_d_list = new ArrayList<Weather>();
		// 1. DocumentBuilderFactory 객체생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			// 2. DocumentBuilder 객체 생성
			DocumentBuilder builder = factory.newDocumentBuilder();

			// DocumentBuilder 객체를 통해 우너하는 XML 문서의 Document 객체를 얻어낸다.
			// 3. Document 객체 생성
			// Document doc = builder.parse("./aaa.xml");

			// 파싱을 통해서 기상청 xml파일에 있는 모든 도시의 정보를 가져온 상태
			Document doc = builder
					.parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp");

			NodeList cityList = doc.getElementsByTagName("city");
			System.out.println(cityList.getLength() + "도시수");

			// 지금부터 각각의 도시에 대한 날씨 정보를 가져오겠음.
			for (int i = 0; i < cityList.getLength(); i++) {
				Node cityNode = cityList.item(i);
				Node tmp_data = cityNode.getNextSibling();
				while (true) {
					tmp_data = tmp_data.getNextSibling();

					if (tmp_data == null)
						break;

					if (tmp_data.getNodeType() == Node.ELEMENT_NODE) {
						// dataList에는 mode,tmEf,wf,tmn,tmx,reliability 에 대한 정보가
						// 담겨있다.
						NodeList dataList = tmp_data.getChildNodes();
						// 정보 객체 하나하나..콩!
						Weather w_tmp = new Weather();

						// 먼저 어떤 도시인지 입력
						w_tmp.setCity(cityNode.getChildNodes().item(0)
								.getNodeValue());

						// 지금부터 나머지 콩데이터를 채울거임!
						for (int j = 0; j < dataList.getLength(); j++) {
							Node data = dataList.item(j);
							if (data.getNodeType() == Node.ELEMENT_NODE) {
								// j번째 데이터 노드에 대한 정보를 스위치 문으로 콩에 채우기 시작함.

								switch (data.getNodeName()) {
								case "mode":
									w_tmp.setMode(data.getChildNodes().item(0)
											.getNodeValue());
									break;
								case "tmEf":
									w_tmp.setTmEf(data.getChildNodes().item(0)
											.getNodeValue());
									break;
								case "wf":
									w_tmp.setWf(data.getChildNodes().item(0)
											.getNodeValue());
									break;
								case "tmn":
									w_tmp.setTmn(data.getChildNodes().item(0)
											.getNodeValue());
									break;
								case "tmx":
									w_tmp.setTmx(data.getChildNodes().item(0)
											.getNodeValue());
									break;
								case "reliability":
									w_tmp.setReliability(data.getChildNodes()
											.item(0).getNodeValue());
									break;
								}
							}
						}

						w_d_list.add(w_tmp);
						w_tmp = null;

					}

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error;");
			e.printStackTrace();
		}
		return w_d_list;
	}
}
