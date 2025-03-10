<template>
 <div>
   <div class="page-title">
      <h3>Диаграмма отзывов</h3>
    </div>

    <BarChart />
  </div>
</template>

<script>
import BarChart from "./BarCharts.vue";

export default {
  name: "historyPage",
  components: {
    BarChart,
  },
};

</script>