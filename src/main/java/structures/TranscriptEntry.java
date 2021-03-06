package structures;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;
import org.tartarus.snowball.ext.FrenchStemmer;
import service.Application;

import java.util.List;

/**
 * Created by midas on 11/23/2016.
 */
public class TranscriptEntry {
    Double from;
    Double until;
    String speaker;
    String text;

    public TranscriptEntry(Double from, Double until, String speaker, String text) {
        this.from = from;
        this.until = until;
        this.speaker = speaker;
        this.text = cleanText(text);



    }

    public TranscriptEntry(String[] e) {
        this.from = Double.valueOf(e[0]);
        this.until = Double.valueOf(e[1]);
        this.speaker = e[2];
        this.text = cleanText(e[3]);


    }

    private String cleanText(String s) {
        //s=s.toLowerCase();
        s=s.replaceAll("'"," ");
        s = s.replaceAll("<noise>", "");
        s = s.replaceAll("<spoken-noise>", "");
        s = s.replaceAll("<laugh>", "");
        s = s.replaceAll("<UNK>", "");
        s = s.replaceAll("<!sil>", "");
        s= s.replaceAll("-","");
        String cleans = s;
        cleans=cleans.toLowerCase();
        //cleans=cleans.substring(0,cleans.length()-1);
        return cleans;
    }

    public Double getFrom() {
        return from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }

    public Double getUntil() {
        return until;
    }

    public void setUntil(Double until) {
        this.until = until;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = cleanText(text);
    }

    @Override
    public String toString() {
        return this.from + "\t" + this.until + "\t" + this.speaker + "\t" + this.text + "\n";
    }
}
