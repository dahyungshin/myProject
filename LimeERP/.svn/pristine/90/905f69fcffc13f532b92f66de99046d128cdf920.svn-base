package common.tag;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * Select 태그라이브러리 설정
 *
 * @author tnc
 * @version 1.0
 */
public class PagingTag extends RequestContextAwareTag  {
//public class PagingTag extends SimpleTagSupport  {
	
	private final StringBuffer sbSelect = new StringBuffer();

	private String name = null;
	private String href = null;
	private int totalRecordCount = 0;
	private int recordsPerPage = 0;
	private int currentPage = 1;
	private int startIndex = 0;
	private int endIndex = 0;
	private int lastIndex = 0;
	private List<Page> pages = new ArrayList<Page>();
	private Page firstPage = null;
	private Page lastPage = null;
	private Page previousPage = null;
	private Page nextPage = null;
	private int indexPerPage = 5;
	
	/**
	 * 시작 태그 처리
	 *
	 * @return String SELECT태그문자열
	 */
	@Override
	public int doStartTagInternal() throws JspException {
		
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			findStartEndIndex();

			this.href = getHref(request);
			
			for (int i = startIndex; i <= endIndex; i++) {
				pages.add(new Page(i, getURL(i)));
			}

			firstPage = new Page(startIndex, getURL(1));
			lastPage = new Page(lastIndex, getURL(lastIndex));

			if (currentPage - 1 > 0) {
				previousPage = new Page(currentPage - 1, getURL(currentPage - 1));
			} else {
				previousPage = firstPage;
			}

			if (currentPage + 1 < endIndex || currentPage + 1 < lastIndex) {
				nextPage = new Page(currentPage + 1, getURL(currentPage + 1));
			} else {
				nextPage = lastPage;
			}
			
			// TEST
//			this.recordsPerPage = 3;
			pageContext.setAttribute(this.getName(), this);

		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_BODY_INCLUDE;
	}

	
	@Override
	public int doEndTag() throws JspException {
		pages.clear();
		firstPage = null;
		lastPage = null;
		previousPage = null;
		nextPage = null;
		return SKIP_BODY;
	}
	
	private void findStartEndIndex() {

		int interval = indexPerPage;
		
		lastIndex = totalRecordCount / recordsPerPage;
		
		if (totalRecordCount % recordsPerPage > 0) {
			lastIndex += 1;
		}

		startIndex = 1;
		
		while (true) {
			endIndex = startIndex + interval - 1;
			
			if (currentPage >= startIndex && currentPage <= endIndex && endIndex <= lastIndex) {
				break;
			}

			if (endIndex > lastIndex) {
				endIndex = lastIndex;
				break;
			}
			startIndex = endIndex + 1;
		}

		if (endIndex == 0) {
			endIndex = 1;
		}
	}

	private String getURL(int index) {
		String concatUrl = (href.indexOf("?") == -1) ? "?" : "&";
		StringBuffer sb = new StringBuffer();
		sb.append(href).append(concatUrl).append("currentPage=").append(index);
		return sb.toString();
	}

	// 넘어온 파라미터를 URI뒤에 이어붙여준다
	private String getHref(HttpServletRequest request) {

		String href = (String) request.getAttribute("javax.servlet.forward.request_uri");

		StringBuffer sb = new StringBuffer(256);
		sb.append(href);

		int i = 0;
		
		@SuppressWarnings("unchecked")
		Enumeration<String> e = request.getParameterNames();
		System.out.println("getParameterNames ==> " + request.getParameterNames());
		
		while (e.hasMoreElements()) {
			String param = (String) e.nextElement();
			
			if (!param.equals("currentPage")) {
				String[] values = request.getParameterValues(param);

				for (String value : values) {
					if (i++ == 0) {
						sb.append("?");
					} else {
						sb.append("&");
					}
					sb.append(param).append("=").append(value);
				}
			}
		}

		return sb.toString();
	}

	public class Page {
		private int index = 0;
		private String href = null;

		private Page(int index, String href) {
			this.index = index;
			this.href = href;
		}

		public int getIndex() {
			return index;
		}

		public String getHref() {
			return href;
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	public int getRecordsPerPage() {
		return recordsPerPage;
	}
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public Page getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Page firstPage) {
		this.firstPage = firstPage;
	}
	public Page getLastPage() {
		return lastPage;
	}
	public void setLastPage(Page lastPage) {
		this.lastPage = lastPage;
	}
	public Page getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(Page previousPage) {
		this.previousPage = previousPage;
	}
	public Page getNextPage() {
		return nextPage;
	}
	public void setNextPage(Page nextPage) {
		this.nextPage = nextPage;
	}
	public int getIndexPerPage() {
		return indexPerPage;
	}
	public void setIndexPerPage(int indexPerPage) {
		this.indexPerPage = indexPerPage;
	}
	
	public StringBuffer getSbSelect() {
		return sbSelect;
	}

}
