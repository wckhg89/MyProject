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
		// 1. DocumentBuilderFactory ��ü����
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			// 2. DocumentBuilder ��ü ����
			DocumentBuilder builder = factory.newDocumentBuilder();

			// DocumentBuilder ��ü�� ���� ����ϴ� XML ������ Document ��ü�� ����.
			// 3. Document ��ü ����
			// Document doc = builder.parse("./aaa.xml");

			// �Ľ��� ���ؼ� ���û xml���Ͽ� �ִ� ��� ������ ������ ������ ����
			Document doc = builder
					.parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp");

			NodeList cityList = doc.getElementsByTagName("city");
			System.out.println(cityList.getLength() + "���ü�");

			// ���ݺ��� ������ ���ÿ� ���� ���� ������ ����������.
			for (int i = 0; i < cityList.getLength(); i++) {
				Node cityNode = cityList.item(i);
				Node tmp_data = cityNode.getNextSibling();
				while (true) {
					tmp_data = tmp_data.getNextSibling();

					if (tmp_data == null)
						break;

					if (tmp_data.getNodeType() == Node.ELEMENT_NODE) {
						// dataList���� mode,tmEf,wf,tmn,tmx,reliability �� ���� ������
						// ����ִ�.
						NodeList dataList = tmp_data.getChildNodes();
						// ���� ��ü �ϳ��ϳ�..��!
						Weather w_tmp = new Weather();

						// ���� � �������� �Է�
						w_tmp.setCity(cityNode.getChildNodes().item(0)
								.getNodeValue());

						// ���ݺ��� ������ �ᵥ���͸� ä�����!
						for (int j = 0; j < dataList.getLength(); j++) {
							Node data = dataList.item(j);
							if (data.getNodeType() == Node.ELEMENT_NODE) {
								// j��° ������ ��忡 ���� ������ ����ġ ������ �ῡ ä��� ������.

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
