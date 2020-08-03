<template>
  <div id="main">
    <div class="header">
      <h1 class="title">Movies</h1>
    </div>

    <router-link to="/movies" tag="button" class="button is-primary">Add Movie</router-link>

    <div class="content">

      <table id="movie" class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Movie Title</th>
            <th>Movie Length</th>
            <th>Release Date</th>
          </tr>
        </thead>
        <tbody>
            <tr v-for="movie in movie" :key="movie.id">
              <td>{{ movie.id }}</td>
              <td>{{ movie.movieTitle}}</td>
              <td>{{ movie.movieLength }}</td>
              <td>{{ movie.releaseDate }}</td>
            </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>