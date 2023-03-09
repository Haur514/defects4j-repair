package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;

/**
 * A {@code <!DOCTPYE>} node.
 */
public class DocumentType extends Node {
    // todo: quirk mode from publicId and systemId

    private DocumentType() {}

    public DocumentType(String name, String publicId, String systemId, String baseUri) {
        super(baseUri);

        attr("name", name);
        attr("publicId", publicId);
        attr("systemId", systemId);
    }

    @Override
    public String nodeName() {
        return "#doctype";
    }

    @Override
    void outerHtmlHead(StringBuilder accum, int depth, Document.OutputSettings out) {
        accum.append("<!DOCTYPE html");
        if (!StringUtil.isBlank(attr("publicId")))
            accum.append(" PUBLIC \"").append(attr("publicId")).append("\"");
        if (!StringUtil.isBlank(attr("systemId")))
            accum.append(' ').append(attr("systemId")).append("\"");
        accum.append('>');
    }

    @Override
    void outerHtmlTail(StringBuilder accum, int depth, Document.OutputSettings out) {
    }
}
