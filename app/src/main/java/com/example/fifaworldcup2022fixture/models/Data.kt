package com.example.fifaworldcup2022fixture.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attendance")
    val attendance: Any?,
    @SerializedName("awayName")
    val awayName: String?,
    @SerializedName("countryName")
    val countryName: Any?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("elapsedPlus")
    val elapsedPlus: Int?,
    @SerializedName("eventsHash")
    val eventsHash: Any?,
    @SerializedName("homeName")
    val homeName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("idAway")
    val idAway: Int?,
    @SerializedName("idCountry")
    val idCountry: Any?,
    @SerializedName("idHome")
    val idHome: Int?,
    @SerializedName("idLeague")
    val idLeague: Int?,
    @SerializedName("idSeason")
    val idSeason: Int?,
    @SerializedName("idStage")
    val idStage: Int?,
    @SerializedName("idVenue")
    val idVenue: Any?,
    @SerializedName("leagueName")
    val leagueName: String?,
    @SerializedName("lineupsHash")
    val lineupsHash: Any?,
    @SerializedName("referees")
    val referees: Any?,
    @SerializedName("round")
    val round: Int?,
    @SerializedName("seasonName")
    val seasonName: String?,
    @SerializedName("statsHash")
    val statsHash: Any?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("team_away_1stHalf_goals")
    val teamAway1stHalfGoals: Int?,
    @SerializedName("team_away_2ndHalf_goals")
    val teamAway2ndHalfGoals: Int?,
    @SerializedName("team_away_90min_goals")
    val teamAway90minGoals: Int?,
    @SerializedName("team_away_ET_goals")
    val teamAwayETGoals: Int?,
    @SerializedName("team_away_PEN_goals")
    val teamAwayPENGoals: Int?,
    @SerializedName("team_home_1stHalf_goals")
    val teamHome1stHalfGoals: Int?,
    @SerializedName("team_home_2ndHalf_goals")
    val teamHome2ndHalfGoals: Int?,
    @SerializedName("team_home_90min_goals")
    val teamHome90minGoals: Int?,
    @SerializedName("team_home_ET_goals")
    val teamHomeETGoals: Int?,
    @SerializedName("team_home_PEN_goals")
    val teamHomePENGoals: Int?,
    @SerializedName("venueName")
    val venueName: Any?
)