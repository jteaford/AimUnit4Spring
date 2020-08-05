<template>
  <div id="main">
    <div class="header">
      <h1 class="title">Movies</h1>
    </div>

    <router-link to="/movie" tag="button" class="button is-primary">Add Movie</router-link>

    <div class="content">

      <table id="movies" class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Movie Title</th>
            <th>Movie Length</th>
            <th>Release Date</th>
          </tr>
        </thead>
        <tbody>
            <tr v-for="movie in movies" :key="movie.id">
              <td>{{ movie.id }}</td>
              <td>{{ movie.movieTitle }}</td>
              <td>{{ movie.movieLength }}</td>
              <td>{{ movie.releaseDate }}</td>
            </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>


<script>
export default {
    name: 'Movies',
    data: () => ({ 
      movies: [] 
    }),
        async mounted() {
            console.log('movies mounted begin');
            const { data } = await this.$http.get('http://localhost:8080/api/movie');
            console.log('movies mounted data', data);
            this.movies = data;
        },
}
</script>

<style scoped>
  button {
    float: right;
  }

  .content table th:not([align]) {
    text-align: left;
  }
</style>