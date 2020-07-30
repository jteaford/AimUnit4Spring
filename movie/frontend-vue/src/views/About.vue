<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
</template>

<script>
export default {
    name: 'Actors',
    data: () => ({ actors: [] }),
        async mounted() {
            console.log('actors mounted begin');
            const { data } = await this.$http.get('http://localhost:8080/api/actors');
            console.log('actors mounted data', data);
            this.actors = data;
        },
}
