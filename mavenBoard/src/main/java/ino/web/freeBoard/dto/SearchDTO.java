package ino.web.freeBoard.dto;

public class SearchDTO {
	
	private String Type;
	private String SearchText;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getSearchText() {
		return SearchText;
	}
	public void setSearchText(String searchText) {
		SearchText = searchText;
	}
	public SearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchDTO(String type, String searchText) {
		super();
		Type = type;
		SearchText = searchText;
	}
	@Override
	public String toString() {
		return "SearchDTO [Type=" + Type + ", SearchText=" + SearchText + ", getType()=" + getType()
				+ ", getSearchText()=" + getSearchText() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}