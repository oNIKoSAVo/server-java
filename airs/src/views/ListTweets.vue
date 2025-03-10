<template>
  <div>
    <div class="page-title">
      <h3>Список твитов</h3>
    </div>


          <section>
            <table>
              <tr>
                <th width="5%">#</th>
                <th width="75%">Текст твита</th>
                <th width="10%">Авиокомпания</th>
                <th width="10%">Тип отзыва</th>
              </tr>
              
                  <tr  v-for="(item, index) in tweets" :key="index">
                        <td>{{ index }}</td>
                        <td >{{ item.text }}</td>
                        <td >{{ item.airline }}</td>
                        <td >{{ item.airline_sentiment }}</td> 
                  </tr>
            </table>
          </section>
        

  </div>
</template>

<script>
export default {
  
  name: 'listTweets',
 data() {
    return {
      tweets: null
    };
  },
  async created() {
    // Simple GET request using fetch
    const response = await fetch("http://localhost:3000/tweet");
    const data = await response.json();
    this.tweets = data;
  }
}
</script>

