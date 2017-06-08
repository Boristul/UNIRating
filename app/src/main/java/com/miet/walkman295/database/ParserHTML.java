package com.miet.walkman295.database;

/**
 * Created by Boris on 24.05.2017.
 */

public class ParserHTML {
    private Integer parserHTMLRating_id;
    private String parserHTMLRating_name;
    private  Integer parserHTMLRating_rating1;
    private Integer parserHTMLRating_rating2;
    private Integer parserHTMLRating_rating3;

    public ParserHTML(Integer parserHTMLRating_id, String parserHTMLRating_name,
                      Integer parserHTMLRating_rating1, Integer parserHTMLRating_rating2, Integer parserHTMLRating_rating3) {
        this.parserHTMLRating_id = parserHTMLRating_id;
        this.parserHTMLRating_name = parserHTMLRating_name;
        this.parserHTMLRating_rating1 = parserHTMLRating_rating1;
        this.parserHTMLRating_rating2 = parserHTMLRating_rating2;
        this.parserHTMLRating_rating3 = parserHTMLRating_rating3;
    }

    public Integer getParserHTMLRating_id() {
        return parserHTMLRating_id;
    }

    public void setParserHTMLRating_id(Integer parserHTMLRating_id) {
        this.parserHTMLRating_id = parserHTMLRating_id;
    }

    public String getParserHTMLRating_name() {
        return parserHTMLRating_name;
    }

    public void setParserHTMLRating_name(String parserHTMLRating_name) {
        this.parserHTMLRating_name = parserHTMLRating_name;
    }

    public Integer getParserHTMLRating_rating1() {
        return parserHTMLRating_rating1;
    }

    public void setParserHTMLRating_rating1(Integer parserHTMLRating_rating1) {
        this.parserHTMLRating_rating1 = parserHTMLRating_rating1;
    }

    public Integer getParserHTMLRating_rating2() {
        return parserHTMLRating_rating2;
    }

    public void setParserHTMLRating_rating2(Integer parserHTMLRating_rating2) {
        this.parserHTMLRating_rating2 = parserHTMLRating_rating2;
    }

    public Integer getParserHTMLRating_rating3() {
        return parserHTMLRating_rating3;
    }

    public void setParserHTMLRating_rating3(Integer parserHTMLRating_rating3) {
        this.parserHTMLRating_rating3 = parserHTMLRating_rating3;
    }
}
