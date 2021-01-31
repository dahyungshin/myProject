(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("test");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsAccount", this);
            obj.set_useclientlayout("true");
            obj._setContents("<ColumnInfo><Column id=\"accountSeq\" type=\"STRING\" size=\"256\"/><Column id=\"profitCost\" type=\"STRING\" size=\"256\"/><Column id=\"bigGroup\" type=\"STRING\" size=\"256\"/><Column id=\"middleGroup\" type=\"STRING\" size=\"256\"/><Column id=\"smallGroup\" type=\"STRING\" size=\"256\"/><Column id=\"detailGroup\" type=\"STRING\" size=\"256\"/><Column id=\"comments\" type=\"STRING\" size=\"256\"/><Column id=\"transactionMoney\" type=\"INT\" size=\"256\" prop=\"TEXT\"/><Column id=\"transactionDate\" type=\"STRING\" size=\"256\"/><Column id=\"writer\" type=\"STRING\" size=\"256\"/><Column id=\"regDate\" type=\"STRING\" size=\"256\"/><Column id=\"uiRowType\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds00", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsIn", this);
            obj._setContents("<ColumnInfo><Column id=\"category\" type=\"STRING\" size=\"256\"/><Column id=\"code\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsOut", this);
            obj._setContents("<ColumnInfo><Column id=\"cost\" type=\"STRING\" size=\"256\"/><Column id=\"Column1\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds01", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds02", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds03", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds04", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"comKor\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Tab("tab00","39","476","1221","232",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_tabindex("0");
            this.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage1",this.tab00);
            obj.set_text("Tabpage1");
            obj.set_url("pattern::tabPage01-codeList.xfdl");
            this.tab00.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage2",this.tab00);
            obj.set_text("Tabpage2");
            this.tab00.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage3",this.tab00);
            obj.set_text("Tabpage3");
            this.tab00.addChild(obj.name, obj);

            obj = new Div("div00","13","12","1257","492",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("div00");
            this.addChild(obj.name, obj);

            obj = new Div("div_Bottom","19","0","1238","444",null,null,null,null,null,null,this.div00.form);
            obj.set_taborder("1");
            obj.set_text("div00");
            this.div00.addChild(obj.name, obj);

            obj = new Grid("grd00","9","13","240","75",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds00");
            obj.set_autofittype("col");
            obj.set_autosizingtype("none");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"코드\"/><Cell col=\"1\" text=\"코드명\"/></Band><Band id=\"body\"><Cell text=\"bind:code\"/><Cell col=\"1\" text=\"bind:comKor\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Grid("grd01","7","260","1220","184",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("1");
            obj.set_binddataset("dsAccount");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"214\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/><Row size=\"24\" band=\"summ\"/></Rows><Band id=\"head\"><Cell text=\"수익/비용\"/><Cell col=\"1\" text=\"관\"/><Cell col=\"2\" text=\"항\"/><Cell col=\"3\" text=\"목\"/><Cell col=\"4\" text=\"과\"/><Cell col=\"5\" text=\"내용\"/><Cell col=\"6\" text=\"금액\"/><Cell col=\"7\" text=\"거래일자\" calendardisplaynulltype=\"default\"/><Cell col=\"8\" text=\"작성자\"/><Cell col=\"9\" text=\"등록일\"/></Band><Band id=\"body\"><Cell text=\"bind:profitCost\" edittype=\"combo\" combodataset=\"ds00\" comboautoselect=\"true\" combocodecol=\"code\" combodatacol=\"comKor\" displaytype=\"combocontrol\"/><Cell col=\"1\" text=\"bind:bigGroup\" edittype=\"combo\" displaytype=\"combocontrol\" combodataset=\"ds01\" combocodecol=\"code\" combodatacol=\"comKor\"/><Cell col=\"2\" text=\"bind:middleGroup\" edittype=\"combo\" displaytype=\"combocontrol\" combodataset=\"ds02\" combocodecol=\"code\" combodatacol=\"comKor\"/><Cell col=\"3\" text=\"bind:smallGroup\" edittype=\"combo\" displaytype=\"combocontrol\" combodataset=\"ds03\" combocodecol=\"code\" combodatacol=\"comKor\"/><Cell col=\"4\" text=\"bind:detailGroup\" edittype=\"combo\" displaytype=\"combocontrol\" combodataset=\"ds04\" combocodecol=\"code\" combodatacol=\"comKor\"/><Cell col=\"5\" text=\"bind:comments\" edittype=\"text\"/><Cell col=\"6\" text=\"bind:transactionMoney\" edittype=\"text\" displaytype=\"mask\"/><Cell col=\"7\" text=\"bind:transactionDate\" edittype=\"date\" displaytype=\"date\" calendarautoselect=\"false\" calendardisplaynulltype=\"none\"/><Cell col=\"8\" text=\"bind:writer\"/><Cell col=\"9\" text=\"bind:regDate\" displaytype=\"date\"/></Band><Band id=\"summary\"><Cell/><Cell col=\"1\"/><Cell col=\"2\"/><Cell col=\"3\"/><Cell col=\"4\"/><Cell col=\"5\"/><Cell col=\"6\" displaytype=\"currency\" text=\"expr:dataset.getSum('transactionMoney')\" textAlign=\"right\"/><Cell col=\"7\"/><Cell col=\"8\"/><Cell col=\"9\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Grid("grd02","269","13","229","190",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("2");
            obj.set_binddataset("ds02");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"코드\"/><Cell col=\"1\" text=\"코드명\"/></Band><Band id=\"body\"><Cell text=\"bind:code\"/><Cell col=\"1\" text=\"bind:comKor\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Button("addBtn","1011","213","59","33",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("3");
            obj.set_text("행추가");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Button("btn01","1080","213","59","33",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("4");
            obj.set_text("행삭제");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Button("btn02","1149","213","59","33",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("5");
            obj.set_text("저장");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Grid("grd05","508","13","332","190",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("6");
            obj.set_binddataset("ds03");
            obj.set_autofittype("col");
            obj.set_autosizingtype("col");
            obj.set_cellmovingtype("col");
            obj.set_cellsizebandtype("allband");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"코드\"/><Cell col=\"1\" text=\"코드명\"/></Band><Band id=\"body\"><Cell text=\"bind:code\"/><Cell col=\"1\" text=\"bind:comKor\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Grid("grd03","9","103","241","100",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("7");
            obj.set_binddataset("ds01");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"코드\"/><Cell col=\"1\" text=\"코드명\"/></Band><Band id=\"body\"><Cell text=\"bind:code\"/><Cell col=\"1\" text=\"bind:comKor\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            obj = new Grid("grd04","850","13","381","190",null,null,null,null,null,null,this.div00.form.div_Bottom.form);
            obj.set_taborder("8");
            obj.set_binddataset("ds04");
            obj.set_autofittype("col");
            obj.set_autosizingtype("row");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"코드\"/><Cell col=\"1\" text=\"코드명\"/></Band><Band id=\"body\"><Cell text=\"bind:code\"/><Cell col=\"1\" text=\"bind:comKor\" wordWrap=\"char\" autosizerow=\"limitmin\"/></Band></Format></Formats>");
            this.div00.form.div_Bottom.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {
            this._addPreloadList("fdl","pattern::tabPage01-codeList.xfdl");
        };
        
        // User Script
        this.registerScript("pattern05-codePage.xfdl", function() {
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
        		case "searchCode":
        			break;
        		case "accountList":
        			break;
        	}

        };
        /************************************************************************************************
        * CRUD 및 TRANSACTION 서비스 호출 처리
        ************************************************************************************************/
        /**
         * @description 조회
        */
        this.fnSearch = function (dsId,svcId)
        {
        	//this.dsSearch.setColumn(this.dsSearch.rowposition, "searchCondition", this.divSearch.form.cboCondition.value)
        	//

        	// 조회조건 설정
        //  	this.ds00.setColumn(0, "code", this.divSearch.form.cboCondition.value);
        // 	this.ds00.setColumn(0, "com_kor"  , this.divSearch.form.edtKeyword.value);

        	trace(this.dsIn.saveXML())

         	var strSvcId    = "searchCode";
        	var strSvcUrl   = "selectCombo.do";
        	var inData      = "dsIn=dsIn";
        	var outData     = dsId+"=output00";
        	var strArg      = "category=A000000";
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

        this.test_onload = function(obj,e)
        {	this.dsIn.addRow();
        	this.dsIn.setColumn(0, "code"  , "A000000");
        	this.flag=1
        	this.fnSearch("ds00");

        	// account List
        	var strSvcId    = "accountList";
        	var strSvcUrl   = "accuntList.do";
        	var inData      = "";
        	var outData     = "dsAccount=output01";
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

        this.div00_div_Bottom_grd00_oncellclick = function(obj,e)
        {
        	this.dsIn.addRow();
        	this.dsIn.setColumn(0, "code"  , this.ds00.getColumn(this.ds00.rowposition, "code"));
        	this.fnSearch("ds01");
        };

        this.div00_div_Bottom_grd03_oncellclick = function(obj,e)
        {
        	this.dsIn.addRow();
        	this.dsIn.setColumn(0, "code"  , this.ds01.getColumn(this.ds01.rowposition, "code"));
        	this.fnSearch("ds02");
        };

        this.div00_div_Bottom_grd02_oncellclick = function(obj,e)
        {
        	this.dsIn.addRow();
        	this.dsIn.setColumn(0, "code"  , this.ds02.getColumn(this.ds02.rowposition, "code"));
        	this.fnSearch("ds03");
        };

        this.div00_div_Bottom_grd05_oncellclick = function(obj,e)
        {
        	this.dsIn.addRow();
        	this.dsIn.setColumn(0, "code"  , this.ds03.getColumn(this.ds03.rowposition, "code"));
        	this.fnSearch("ds04");
        };

        /************************************************************************************************
        * 행추가
        ************************************************************************************************/
        this.addBtn_onclick = function(obj,e)
        {
        	this.today= gfn_Today();
        	trace(this.today)
        	this.dsAccount.addRow();
        	this.dsAccount.setColumn(this.dsAccount.rowposition,"regDate",this.today);
        	this.dsAccount.setColumn(this.dsAccount.rowposition,"transactionDate",this.today);
        	this.dsAccount.setColumn(this.dsAccount.rowposition,"writer",nexacro.getEnvironmentVariable("gvUserNm"));
        	this.dsAccount.setColumn(this.dsAccount.rowposition,"uiRowType","I");
        };


        function gfn_Today(){
        	var currDate = new Date();
            var year = currDate.getFullYear().toString().padLeft(4, "0");
            var month = (currDate.getMonth()+1).toString().padLeft(2, "0");
            var day = currDate.getDate().toString().padLeft(2, "0");
        	var strToday=year+month+day;
            return strToday;
        }

        this.dsAccount_canrowposchange = function(obj,e)
        {
        /*
        trace(this.dsAccount.getRowType(this.dsAccount.rowposition))
        	if (this.dsAccount.getColumn(this.dsAccount.rowposition,"uiRowType") !="I")
        	{
        		this.dsAccount.setColumn(this.dsAccount.rowposition,"uiRowType","U");
        	}*/
        };

        this.dsAccount_onrowposchanged = function(obj,e)
        {
        	trace(this.dsAccount.getRowType(this.dsAccount.rowposition))
        };

        this.div00_div_Bottom_btn01_onclick = function(obj,e)
        {
        	this.dsAccount.deleteRow(this.div00.form.div_Bottom.form.grd01.getSelectedDatasetRows());
        	//this.dsAccount.deleteRow(this.div00.form.div_Bottom.form.grd01.getBindDataset())
        };

        this.div00_div_Bottom_btn02_onclick = function(obj,e)
        {
        	this.dsAccount.getRowType(this.dsAccount.rowposition)
        	for(var i=0; i<this.dsAccount.getRowCount(); i++)
        	{
        		this.dsAccount.setColumn(i, "uiRowType", this.dsAccount.getRowType(i));
        	}
        	trace(this.dsAccount.saveXML())
        	var strSvcId    = "saveAccount";
        	var strSvcUrl   = "saveAccount.do";
        	var inData      = "dsAccount=dsAccount";
        	var outData     = "";
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

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.test_onload,this);
            this.div00.form.div_Bottom.form.grd00.addEventHandler("oncellclick",this.div00_div_Bottom_grd00_oncellclick,this);
            this.div00.form.div_Bottom.form.grd02.addEventHandler("oncellclick",this.div00_div_Bottom_grd02_oncellclick,this);
            this.div00.form.div_Bottom.form.addBtn.addEventHandler("onclick",this.addBtn_onclick,this);
            this.div00.form.div_Bottom.form.btn01.addEventHandler("onclick",this.div00_div_Bottom_btn01_onclick,this);
            this.div00.form.div_Bottom.form.btn02.addEventHandler("onclick",this.div00_div_Bottom_btn02_onclick,this);
            this.div00.form.div_Bottom.form.grd05.addEventHandler("oncellclick",this.div00_div_Bottom_grd05_oncellclick,this);
            this.div00.form.div_Bottom.form.grd03.addEventHandler("oncellclick",this.div00_div_Bottom_grd03_oncellclick,this);
            this.dsAccount.addEventHandler("canrowposchange",this.dsAccount_canrowposchange,this);
            this.dsAccount.addEventHandler("onrowposchanged",this.dsAccount_onrowposchanged,this);
        };

        this.loadIncludeScript("pattern05-codePage.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
