<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div style="margin-bottom: 100px; min-height: 500px;">
	<form name="formm" method="post" class="noticeWrite" action="boardWriteAction" autocomplete="off" enctype="multipart/form-data">
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
				<td><textarea rows="10" cols="101" name="content" class="form-control" id="content"></textarea></td>
			</tr>
		</table>
		<div id="buttons">
			<input type="submit" value="등록" class="submit" onclick="boardWrite()"> <input type="reset" value="취소" class="cancel" onclick="location.href='getNoticeList'">
		</div>
	</form>
</div>

<script type="text/javascript">
$(function(){
        var oEditors = [];
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: oEditors,
            elPlaceHolder: "content",
            sSkinURI: "<c:url value='/smarteditor2/SmartEditor2Skin.html'/>",
            htParams: {
                bUseToolbar: true,
                bUseVerticalResizer: true,
                bUseModeChanger: true,
                fOnBeforeUnload: function () {
                }
            },
            fOnAppLoad: function () {
            },
            fCreator: "createSEditor2"
        });

        function submitContents(elClickedObj) {
            // 에디터의 내용이 textarea에 적용된다.
            oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
            // 폼 submit
            elClickedObj.form.submit();
        }
});
    </script>
<%@ include file="../footer.jsp"%>