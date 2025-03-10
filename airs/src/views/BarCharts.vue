<script>
import { Bar } from "vue-chartjs";

export default {
  extends: Bar,
    data() {
        return {
        airline: [],
        countPositive: [],
        countNegative: [],
        countNeutral: [],
        };
    },
  async created() {
    const API_URL = process.env.VUE_APP_API_URL;
    const response = await fetch(`${API_URL}/tweetSentiment`);
     const data = await response.json();
        for(var i=0;i<data.length;i++){

            this.airline[i] = data[i].airline;
            this.countPositive[i] = data[i].cntP;
            this.countNegative[i] = data[i].cntNeg;
            this.countNeutral[i] = data[i].cntNeut;
        }

       this.renderChart(
      {
        labels:  this.airline,
        datasets: [
          {
            label: "Положительные отзывы",
            backgroundColor: "#008000",
            data:  this.countPositive
          },
          {
            label: "Отрицательные отзывы",
            backgroundColor: "#960018",
            data:  this.countNegative
          },
          {
            label: "Нейтральные отзывы",
            backgroundColor: "#808080",
            data:  this.countNeutral
          }
        ]
      },
      { responsive: true, maintainAspectRatio: false }
    );
    // var c=0
    // for(var i=0;i<1000;i++){
      
              
    //             this.labels.push(data[i].provinceState)
    //             this.confirmed.push(data[i].confirmed)
    //             c=c+1
    //             if(c==28){
    //               break
    //             }
    //           }
            
    
  }
};
</script>