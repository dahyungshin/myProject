(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("tabPage1");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1221,232);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsAllCode", this);
            obj.set_useclientlayout("true");
            obj._setContents("<ColumnInfo><Column id=\"codeSeq\" type=\"STRING\" size=\"256\"/><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"category\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/><Column id=\"subCom\" type=\"STRING\" size=\"256\"/><Column id=\"useYn\" type=\"STRING\" size=\"256\"/><Column id=\"regDt\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("grd00","8","8","1210","218",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("dsAllCode");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"48\" band=\"left\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"번호\"/><Cell col=\"1\" text=\"코드\"/><Cell col=\"2\" text=\"분류코드\"/><Cell col=\"3\" text=\"코드명\"/><Cell col=\"4\" text=\"-\"/><Cell col=\"5\" text=\"사용유무\"/><Cell col=\"6\" text=\"등록일\"/></Band><Band id=\"body\"><Cell text=\"bind:codeSeq\"/><Cell col=\"1\" text=\"bind:code\" suppress=\"0\"/><Cell col=\"2\" text=\"bind:category\" suppress=\"1\"/><Cell col=\"3\" text=\"bind:comKor\"/><Cell col=\"4\" text=\"bind:subCom\"/><Cell col=\"5\" text=\"bind:useYn\"/><Cell col=\"6\" text=\"bind:regDt\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1221,232,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("tabPage01-codeList.xfdl", function() {

        /************************************************************************************************
         * CALLBACK 콜백 처리부분(Transaction, Popup)
         ************************************************************************************************/
        /**
         * @description Transaction CallBack 함수(선택)
        */
        this.fnCallback = function(svcID,errorCode,errorMsg)
        {
        	// 에러 시 화면 처리 내역
        	if(errorCode != 0)
        	{
        		return;
        	}

        	switch(svcID)
        	{
        		case "allCode":


        			break;

        	}

        };
        	/************************************************************************************************
        * CRUD 및 TRANSACTION 서비스 호출 처리
        ************************************************************************************************/
        /**
         * @description 조회
        */
        this.fnSearchCode = function ()
        {
        	//this.dsSearch.setColumn(this.dsSearch.rowposition, "searchCondition", this.divSearch.form.cboCondition.value)
        	//

        	// 조회조건 설정
        // //  	this.dsSearch.setColumn(0, "searchCondition", this.divSearch.form.cboCondition.value);
        // // 	this.dsSearch.setColumn(0, "searchKeyword"  , this.divSearch.form.edtKeyword.value);
        	trace(this.dsAllCode.saveXML())

         	var strSvcId    = "allCode";
        	var strSvcUrl   = "selectAllCode.do";
        	var inData      = "";
        	var outData     = "dsAllCode=output000";
        	var strArg      = "";
        	var callBackFnc = "fnCallback";
        	var isAsync   	= true;

        	this.gfnTransaction(strSvcId , 		// transaction을 구분하기 위한 svc id값
        						strSvcUrl , 	// trabsaction을 요청할 주소
        						inData , 		// 입력값으로 보낼 dataset id , a=b형태로 실제이름과 입력이름을 매칭
        						outData , 		// 처리결과값으로 받을 dataset id, a=b형태로 실제이름과 입력이름을 매칭
        						strArg, 		// 입력값으로 보낼 arguments, strFormData="20120607"
        						callBackFnc, 	// transaction의 결과를 받을 Function 이름
        						isAsync); 		// 비동기통신 여부 [생략가능]
        };
        this.tabPage1_onload = function(obj,e)
        {
        	this.dsAllCode.addRow();
        	this.fnSearchCode();

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.tabPage1_onload,this);
        };

        this.loadIncludeScript("tabPage01-codeList.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
