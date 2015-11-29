<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript">

  $(document).ready(function() {

    var ctx = $("#producer-diagram").get(0).getContext("2d");
    var data = [];
    if(${ fn:length(producer.souvenirs) == 0}) {
      data.push(
        {
          value: 100,
          color:"#C0C0C0",
          highlight: "#A0A0A0",
          label: "Empty"
        });
    } else {
       data = [
          <c:forEach var="souvenir" items="${producer.souvenirs}">{
          value: ${souvenir.price},
          color: getRandomColor(),
          highlight: "#A0A0A0",
          label: "${souvenir.name}"
        },</c:forEach>
      ];
    }
    var myPieChart = new Chart(ctx).Pie(data);

    ctx.on('mouseleave', function (){
      myPieChart.showTooltip(myPieChart.segments, true);
    });

  });
</script>


<div class="container">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h3 class="panel-title">Souvenir price structure in ${producer.name}</h3>
    </div>
    <div class="panel-body text-center">
        <canvas id="producer-diagram" width="450" height="450"></canvas>
    </div>
    <div class="panel-footer text-right">
      </p>
      <a href="${pageContext.request.contextPath}/producer?id=${producer.id}" class="btn btn-link text-primary">Back</a>
    </div>
  </div>
</div>