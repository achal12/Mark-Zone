package com.test.markzone;

 class Marks {

     private int _id;
     private String _studentName;
     //subject marks
     private String  _SSC;
     private String  _CG;
     private String  _WEB;
     private String _OOMD;
     private String _ELECTIVE;

     public Marks() {
     }

     public Marks(String _studentName, String _SSC, String _CG, String _WEB, String _OOMD,String _ELECTIVE) {
         this._studentName = _studentName;
         this._SSC = _SSC;
         this._CG = _CG;
         this._WEB = _WEB;
         this._OOMD = _OOMD;
         this._ELECTIVE=_ELECTIVE;
     }

     public String get_studentName() {
         return _studentName;
     }

     public String get_SSC() {
         return _SSC;
     }

     public String get_CG() {
         return _CG;
     }

     public String get_WEB() {
         return _WEB;
     }

     public String get_OOMD() {
         return _OOMD;
     }

     public String get_ELECTIVE() {
         return _ELECTIVE;
     }

     public void set_studentName(String _studentName) {
         this._studentName = _studentName;
     }

     public void set_SSC(String _MC) {
         this._SSC = _SSC;
     }

     public void set_CG(String _ACA) {
         this._CG = _CG;
     }

     public void set_WEB(String _FA) {
         this._WEB = _WEB;
     }

     public void set_OOMD(String _FA) {
         this._OOMD = _OOMD;
     }

     public void set_ELECTIVE(String _FA) {
         this._ELECTIVE = _ELECTIVE;
     }

}
