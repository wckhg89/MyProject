<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="map_div">	
	<img src="img/one_px.png"
		style="width: 0px; height: 0px; visibility: hidden;"
			onload="initialize('${param.category}')" />
		<%-- onload="initialize('${pList_loc[0].p_location }')" /> --%>
	
</div>
	