


<%
if (session.getAttribute("mensaje")!=null)
{%>
<script>alert("<%=session.getAttribute("mensaje")%>");</script>
<%session.removeAttribute("mensaje");
	}
%>



  
