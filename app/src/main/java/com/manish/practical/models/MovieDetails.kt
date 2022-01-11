package com.manish.practical.models

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("adult") var adult: Boolean,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("belongs_to_collection") var belongsToCollection: BelongsToCollection,
    @SerializedName("budget") var budget: Int,
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("homepage") var homepage: String,
    @SerializedName("id") var id: Int,
    @SerializedName("imdb_id") var imdbId: String,
    @SerializedName("original_language") var originalLanguage: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("production_companies") var productionCompanies: ArrayList<ProductionCompanies> = arrayListOf(),
    @SerializedName("production_countries") var productionCountries: ArrayList<ProductionCountries> = arrayListOf(),
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("revenue") var revenue: Int,
    @SerializedName("runtime") var runtime: Int,
    @SerializedName("spoken_languages") var spokenLanguages: ArrayList<SpokenLanguages> = arrayListOf(),
    @SerializedName("status") var status: String,
    @SerializedName("tagline") var tagline: String,
    @SerializedName("title") var title: String,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("vote_count") var voteCount: Int

){
    fun getStringGenres(): String{
        return genres.joinToString(
            prefix = "",
            separator = ", ",
            postfix = "",
            transform = {it.name}
        )
    }
    fun getStringProdCompanies(): String {
        return productionCompanies.joinToString(
            prefix = "",
            separator = ", ",
            postfix = "",
            transform = {it.name}
        )
    }
}