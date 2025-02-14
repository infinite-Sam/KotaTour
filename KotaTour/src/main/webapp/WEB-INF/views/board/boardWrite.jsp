<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div style="margin-bottom: 100px; min-height: 500px;">
	<form name="formm" method="post" class="noticeWrite" id="boardWrite" action="boardWriteAction" autocomplete="off" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<br>
		<br>
		<table class="inputNotice">
			<tr>
				<td><label style="margin-right: 20px;">제목</label></td>
				<td><input type="text" name="title" id="title" class="form-control" size="100"></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><label>내용</label></td>
				<td><textarea rows="10" cols="101" name="content" class="form-control" id="content" style="height: 500px; width: auto; border-right-style: solid;"></textarea></td>
			</tr>
		</table>
		<div id="buttons">
			<input type="submit" value="등록" class="submit"> 
			<input type="reset" value="취소" class="cancel" onclick="location.href='getBoardList'">
		</div>
	</form>
</div>

<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({
  oAppRef : oEditors,
  elPlaceHolder : "content",
  sSkinURI : "/smarteditor2/SmartEditor2Skin.html",
  fCreator : "createSEditor2",
  htParams : {
      fOnAppLoad : function(){
          // 서버로부터 사진 업로드 처리 안내 메시지
          oEditors.getById["content"].exec("LOAD_CONTENTS_FUNCTION", ["사진 업로드 준비"]);
      },
      fOnBeforeUnload : function(){},
      // 이미지 업로드 관련 설정
      Image : {
          sUrl : "/boardWriteAction", // 이미지 업로드 기능을 처리할 URL
          sMaxSize : "10000000", // 업로드 사이즈 제한 (10MB)
          sAllowedFileTypes : "png|jpg|jpeg|gif" // 허용할 확장자
      }
  }
});

</script>
<%@ include file="../footer.jsp"%>