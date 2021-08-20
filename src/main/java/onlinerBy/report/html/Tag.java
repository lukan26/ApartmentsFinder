package onlinerBy.report.html;

import java.util.*;

public class Tag {
    String name ="";
    String text = "";
    List<Attribute> attributes = new ArrayList<>();
    List<Tag> nestedTags = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Tag addAttribute(Attribute attribute){
        attributes.add(attribute);
        return this;
    }

    public Tag addTag(Tag tag){
        nestedTags.add(tag);
        return this;
    }

    public List<Tag> getNestedTags() {
        return nestedTags;
    }

    public void setNestedTags(List<Tag> nestedTags) {
        this.nestedTags = nestedTags;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Tag addText(String text) {
        this.text = text;
        return this;
    }
}
