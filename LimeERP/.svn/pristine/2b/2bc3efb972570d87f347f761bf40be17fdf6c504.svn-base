package common.tag;

import java.io.Serializable;

public abstract class CommonBaseModel implements Serializable {

	private int startRowNum = 0;

	private int currentPage = 1;

	private int pageUnit = 10;

	private int pageSize = 10;

	@SuppressWarnings("unused")
	private int firstIndex = 1;

	@SuppressWarnings("unused")
	private int lastIndex = 1;

	/** 페이지 당 출력될 row */
	private int recordCountPerPage = 10;

	private int totalCount = 0;

	private int rowNum = 0;

	public void setStartRowNum() {
		startRowNum = (currentPage - 1) * recordCountPerPage;
	}

	public int getStartRowNum() {
		return startRowNum = (currentPage -1) * recordCountPerPage;
	}

	public int getFirstIndex() {
		return (currentPage - 1) * recordCountPerPage + 1;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getLastIndex() {
		return getFirstIndex() + recordCountPerPage - 1;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

}
