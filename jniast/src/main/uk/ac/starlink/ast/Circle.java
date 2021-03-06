/* ********************************************************
 * This file automatically generated by Circle.pl.
 *                   Do not edit.                         *
 **********************************************************/

package uk.ac.starlink.ast;


/**
 * Java interface to the AST Circle class
 *  - a circular or spherical region within a Frame. 
 * The Circle class implements a Region which represents a circle or
 * sphere within a Frame.
 * <h4>Licence</h4>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public Licence as
 * published by the Free Software Foundation; either version 2 of
 * the Licence, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be
 * useful,but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public Licence for more details.
 * <p>
 * You should have received a copy of the GNU General Public Licence
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street,Fifth Floor, Boston, MA
 * 02110-1301, USA
 * 
 * 
 * @see  <a href='http://star-www.rl.ac.uk/cgi-bin/htxserver/sun211.htx/?xref_Circle'>AST Circle</a>  
 */
public class Circle extends Region {
    /** 
     * Create a Circle.   
     * This function creates a new Circle and optionally initialises its
     * attributes.
     * <p>
     * A Circle is a Region which represents a circle or sphere within the
     * supplied Frame.
     * <h4>Notes</h4>
     * <br> - A null Object pointer (AST__NULL) will be returned if this
     * function is invoked with the AST error status set, or if it
     * should fail for any reason.
     * @param  frame  A pointer to the Frame in which the region is defined. A deep
     * copy is taken of the supplied Frame. This means that any
     * subsequent changes made to the Frame using the supplied pointer
     * will have no effect the Region.
     * 
     * @param  form  Indicates how the circle is described by the remaining parameters.
     * A value of zero indicates that the circle is specified by a
     * centre position and a position on the circumference. A value of one
     * indicates that the circle is specified by a centre position and a
     * scalar radius.
     * 
     * @param  unc  An optional pointer to an existing Region which specifies the
     * uncertainties associated with the boundary of the Circle being created.
     * The uncertainty in any point on the boundary of the Circle is found by
     * shifting the supplied "uncertainty" Region so that it is centred at
     * the boundary point being considered. The area covered by the
     * shifted uncertainty Region then represents the uncertainty in the
     * boundary position. The uncertainty is assumed to be the same for
     * all points.
     * <p>
     * If supplied, the uncertainty Region must be of a class for which
     * all instances are centro-symetric (e.g. Box, Circle, Ellipse, etc.)
     * or be a Prism containing centro-symetric component Regions. A deep
     * copy of the supplied Region will be taken, so subsequent changes to
     * the uncertainty Region using the supplied pointer will have no
     * effect on the created Circle. Alternatively,
     * a NULL Object pointer
     * may be supplied, in which case a default uncertainty is used
     * equivalent to a box 1.0E-6 of the size of the Circle being created.
     * <p>
     * The uncertainty Region has two uses: 1) when the
     * astOverlap
     * function compares two Regions for equality the uncertainty
     * Region is used to determine the tolerance on the comparison, and 2)
     * when a Region is mapped into a different coordinate system and
     * subsequently simplified (using
     * astSimplify),
     * the uncertainties are used to determine if the transformed boundary
     * can be accurately represented by a specific shape of Region.
     * 
     * @throws  AstException  if an error occurred in the AST library
    */
    public Circle( Frame frame, int form, double[] centre, double[] point, Region unc ) {
        construct( frame, form, centre, point, unc );
    }
    private native void construct( Frame frame, int form, double[] centre, double[] point, Region unc );


    /**
     * Create a Circle given a centre and radius.
     *
     * @param  frame   frame in which region will exist (a deep copy is taken)
     * @param  centre  Naxes-element array giving centre of circle region
     * @param  radius  radius of circle region
     * @param  unc     uncertainty associated with the circle's boundary;
     *                 may be null
     * @see    #Circle(uk.ac.starlink.ast.Frame,int,double[],double[],uk.ac.starlink.ast.Region)
     */
    public Circle( Frame frame, double[] centre, double radius, Region unc ) {
        this( frame, 1, centre, new double[] { radius }, unc );
    }

    /**
     * Create a Circle given a centre and point on the circumference.
     *
     * @param  frame   frame in which region will exist (a deep copy is taken)
     * @param  centre  Naxes-element array giving centre of circle region
     * @param  point   Naxes-element array giving a point on the circle
     *                 region's circumference
     * @param  unc     uncertainty associated with the circle's boundary;
     *                 may be null
     * @see    #Circle(uk.ac.starlink.ast.Frame,int,double[],double[],uk.ac.starlink.ast.Region)
     */
    public Circle( Frame frame, double[] centre, double[] point, Region unc ) {
        this( frame, 0, centre, point, unc );
    }
}
