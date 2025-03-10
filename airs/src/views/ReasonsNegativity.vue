<template>
 <div>
   <div class="page-title">
      <h3>Причины негатива</h3>
    </div>

    <BarChart />
  </div>
</template>

<script>
import BarChart from "./BarChartsReason.vue";

export default {
  name: "feedbackChart",
  components: {
    BarChart,
  },
};

</script>