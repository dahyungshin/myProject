package domain.dto;

import common.tag.CommonBaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @desc	코드 관리 DTO
 * @author	조승아
 * @version	0.1
 */
@Getter
@Setter
@ToString
public class CodeDto extends CommonBaseModel {

	private String cdNo;		// 코드순번
	private String comDivCd;	// 코드구분
	private String comDivNm;	// 코드구분명
	private String detailCd;	// 상세코드
	private String detailNm;	// 상세코드명
	private String useFl;		// 사용여부
	private String regDt;		// 등록일자
	private String regUsrId;	// 등록자ID
	private String chgDt;		// 수정일자
	private String chgUsrId;	// 수정자ID
	
}
