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
    name: 'AddMovie',
    data: () => ({
        movie: {
            movieTitle: "",
            movieLength: "",
            releaseDate: ""
        }
    }),

    methods: {
        cancel() {
            this.$router.push({path: '/movie'});
        },
        async save() {
            const response = await this.$http.post('http://localhost:8080/api/movie', this.movie)
            console.log(response);
            if (response.status === 200) {
                this.$router.push({path: '/movie'});
            }
        }
    }
}
</script>