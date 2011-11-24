/*
 * $Id: TextData.java,v 1.9 2001/07/22 22:01:59 johnr Exp $
 *
 * Copyright (c) 1998-2001 The Regents of the University of California.
 * All rights reserved. See the file COPYRIGHT for details.
 */
package diva.sketch.toolbox;
import diva.sketch.recognition.Type;
import diva.sketch.recognition.TypedData;
import diva.util.xml.AbstractXmlBuilder;
import diva.util.xml.XmlElement;

/**
 * A typed data that holds a recognized text string.
 * An object of this type might is generated by the
 * Calligrapher recognizer, and can be used as a common
 * type for text recognized by any handwriting recognition
 * software.
 *
 * @author Michael Shilman  (michaels@eecs.berkeley.edu)
 * @version $Revision: 1.9 $
 * @rating Red
 */
public class TextData extends AbstractXmlBuilder implements TypedData {
    /**
     * The static type associated with this typed data.
     */
    public static final Type type = Type.makeType(TextData.class);

    /**
     * The semantic text associated with this data.
     */
    private String _text;
	
    /**
     * Construct a text data that contains an empty string.
     */
    public TextData() {
        this("");
    }
    
    /**
     * Construct a text data that contains the given string.
     */
    public TextData(String text) {
        _text = text;
    }
    
    /**
     * Return the type of this data, implementing the TypedData
     * interface.  Returns the static type <i>TextData.type</i>.
     */
    public Type getType() {
        return TextData.type;
    }
	
    /**
     * Return the text string contained by this data.
     */
    public String getText() {
        return _text;
    }

    /**
     * Set the text string contained by this data.
     */
    public void setText(String text) {
        _text = text;
    }

    /**
     * Equality test: are the strings identical?
     */
    public boolean equals(Object o) {
        if(o instanceof TextData) {
            String text = ((TextData)o).getText();
            return _text.equals(text);
        }
        return false;
    }

    public Object build(XmlElement in, String type) {
        setText(in.getPCData());
        return this;
    }

    public XmlElement generate(Object in) {
        TextData dat = (TextData)in;
        XmlElement out = new XmlElement(in.getClass().getName());
        out.appendPCData(dat.getText());
        return out;
    }
    
    /**
     * Return a string representation of this data for debugging.
     */
    public String toString() {
        return "TextData[" + _text + "]";
    }
}

