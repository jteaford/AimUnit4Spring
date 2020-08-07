<template>
    <div>
        <h1 class="title">Add Movie</h1>

        <div class="field"> 
            <label class="label">Movie Title</label>
            <div class="control">
                <input class="input" type="text" v-model="movie.movieTitle" placeholder="Movie Title" />
            </div> 
        </div>

        <div class="field"> 
            <label class="label">Movie Length</label>
            <div class="control">
                <input class="input" type="text" v-model="movie.movieLength" placeholder="Movie Length" />
            </div> 
        </div>

        <div class="field"> 
            <label class="label">Release Date</label>
            <div class="control">
                <input class="input" type="text" v-model="movie.releaseDate" placeholder="Release Date" />
            </div> 
        </div>

        <select v-model="movie.director.id">
            <option v-for="director in directors" :value="director.id" :key="director.id">
                {{ director.firstName }} {{ director.lastName }}
            </option>
        </select>

        <!-- <select v-model="movie.genre.id">
            <option v-for="genre in genres" :value="genre.id" :key="genre.id">
                {{ genre.firstName }} {{ genre.lastName }}
            </option>
        </select> -->
   
        <div class="field is-grouped">
            <p class="control">
                <button v-on:click="cancel" class="button">Cancel</button>
            </p> 
            <p class="control">
                <button v-on:click="save" class="button">Save</button>
            </p>
        </div>
    </div>
</template>

<script>
export default {
    data: () => ({
        movie: {
            director: {}
        },
        directors: [],
        genres: []
    }),

    async mounted() {
        const { data } = await this.$http.get('http://localhost:8080/api/directors');
        console.log('getDirectors() directors', data)
        this.directors = data;
    },

    methods: {
        cancel() {
            this.$router.push({path: '/movies'});
        },
        async save() {
            const response = await this.$http.post('http://localhost:8080/api/movies', this.movie)
            console.log(response);
            if (response.status === 200) {
                this.$router.push({path: '/movies'});
            }
        }
    }
}
</script>