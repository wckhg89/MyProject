package pack;

public class HeaderBean {
	private String headerName;
	private String header;
	private String headerTable;

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
		this.headerTable += "<th>" + headerName + "</th>";
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
		this.headerTable += "<td>" + header + "</td></tr>";
	}

	public String getHeaderTable() {
		return headerTable;
	}

	public void setHeaderTable(String headerTable) {
		this.headerTable = headerTable;
	}

}
