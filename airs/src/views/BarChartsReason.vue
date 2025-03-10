<script>
import { Bar } from "vue-chartjs";

export default {
  extends: Bar,
    data() {
        return {
        airlineCount: [],
        airlineName: [],
        reasonName: [],
        };
    },
    async created() {
    var response = await fetch("http://localhost:3000/tweetNegativeReason");
    const data = await response.json();

    this.airlineName = [...new Set(data.map(d => d.airline))];

    let groupedData = {};
    data.forEach(({ airline, negativereason, count }) => {
        if (!groupedData[negativereason]) {
            groupedData[negativereason] = Array(this.airlineName.length).fill(0);
        }
        let airlineIndex = this.airlineName.indexOf(airline);
        if (airlineIndex !== -1) {
            groupedData[negativereason][airlineIndex] = count;
        }
    });

    this.reasonName = Object.keys(groupedData);
    this.airlineCount = Object.values(groupedData);
    this.renderChart({
        labels: this.airlineName, 
        datasets: this.reasonName.map((reason, i) => ({
            label: reason,
            backgroundColor: this.getRandomColor(i),
            data: this.airlineCount[i]
        }))
    }, { responsive: true, maintainAspectRatio: false });
},

methods: {
    getRandomColor(index) {
        const colors = [
            "#FF5733", "#33FF57", "#3357FF", "#FF33A8",
            "#FF8C33", "#57FF33", "#33FFF5", "#D133FF"
        ];
        return colors[index % colors.length];
    }
}


};
</script>