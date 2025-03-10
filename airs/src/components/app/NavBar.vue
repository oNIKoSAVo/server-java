<template>
  <nav class="navbar orange lighten-1">
    <div class="nav-wrapper">
      <div class="navbar-left">
        <a href="#" @click.prevent="$emit('click')">
          <i class="material-icons black-text">dehaze</i>
        </a>
        <span class="black-text">{{date | date('datetime')}}</span>
      </div>
    </div>
  </nav>
</template>

<script>

export default {
  data:() => ({
    date : new Date()
  }),
  mounted() {
     setInterval(()=> {
       this.date = new Date()
     },1000)
  }
}
</script>
