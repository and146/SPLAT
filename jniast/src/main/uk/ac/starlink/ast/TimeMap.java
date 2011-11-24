/* ********************************************************
 * This file automatically generated by TimeMap.pl.
 *                   Do not edit.                         *
 **********************************************************/

package uk.ac.starlink.ast;


/**
 * Java interface to the AST TimeMap class
 *  - sequence of time coordinate conversions. 
 * A TimeMap is a specialised form of 1-dimensional Mapping which can be 
 * used to represent a sequence of conversions between standard time
 * coordinate systems.
 * <p>
 * When a TimeMap is first created, it simply performs a unit
 * (null) Mapping. Using the astTimeAdd
 * function, a series of coordinate conversion steps may then be
 * added. This allows multi-step conversions between a variety of 
 * time coordinate systems to be assembled out of a set of building 
 * blocks.
 * <p>
 * For details of the individual coordinate conversions available,
 * see the description of the astTimeAdd function.
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
 * Foundation, Inc., 59 Temple Place,Suite 330, Boston, MA
 * 02111-1307, USA
 * 
 * 
 * @see  <a href='http://star-www.rl.ac.uk/cgi-bin/htxserver/sun211.htx/?xref_TimeMap'>AST TimeMap</a>  
 */
public class TimeMap extends Mapping {
    /**
     * Create a TimeMap.
     */
    public TimeMap() {
        this( 0 );
    }

    /** 
     * Create a TimeMap.   
     * This function creates a new TimeMap and optionally initialises
     * its attributes.
     * <p>
     * A TimeMap is a specialised form of 1-dimensional Mapping which can be 
     * used to represent a sequence of conversions between standard time
     * coordinate systems.
     * <p>
     * When a TimeMap is first created, it simply performs a unit
     * (null) Mapping. Using the astTimeAdd
     * function, a series of coordinate conversion steps may then be
     * added. This allows multi-step conversions between a variety of 
     * time coordinate systems to be assembled out of a set of building 
     * blocks.
     * <p>
     * For details of the individual coordinate conversions available,
     * see the description of the astTimeAdd function.
     * <h4>Notes</h4>
     * <br> - The nature and units of the coordinate values supplied for the
     * first input (i.e. the time input) of a TimeMap must be appropriate 
     * to the first conversion step applied by the TimeMap. For instance, if 
     * the first conversion step is "MJDTOBEP" (Modified Julian Date to
     * Besselian epoch) then the coordinate values for the first input should
     * be date in units of days. Similarly, the nature and units of the 
     * coordinate values returned by a TimeMap will be determined by the
     * last conversion step applied by the TimeMap. 
     * <br> - A null Object pointer (AST__NULL) will be returned if this
     * function is invoked with the AST error status set, or if it
     * should fail for any reason.
     * @param  flags  This parameter is reserved for future use and should currently
     * always be set to zero.
     * 
     * @throws  AstException  if an error occurred in the AST library
    */
    public TimeMap( int flags ) {
        construct( flags );
    }
    private native void construct( int flags );

    /** 
     * Add a time coordinate conversion to a TimeMap.   
     * This function adds one of the standard time coordinate
     * system conversions listed below to an existing TimeMap.
     * <p>
     * When a TimeMap is first created (using astTimeMap), it simply
     * performs a unit (null) Mapping. By using astTimeAdd (repeatedly
     * if necessary), one or more coordinate conversion steps may then
     * be added, which the TimeMap will perform in sequence. This allows
     * multi-step conversions between a variety of time coordinate
     * systems to be assembled out of the building blocks provided by
     * this class.
     * <p>
     * Normally, if a TimeMap's Invert attribute is zero (the default),
     * then its forward transformation is performed by carrying out
     * each of the individual coordinate conversions specified by
     * astTimeAdd in the order given (i.e. with the most recently added
     * conversion applied last).
     * <p>
     * This order is reversed if the TimeMap's Invert attribute is
     * non-zero (or if the inverse transformation is requested by any
     * other means) and each individual coordinate conversion is also
     * replaced by its own inverse. This process inverts the overall
     * effect of the TimeMap. In this case, the first conversion to be
     * applied would be the inverse of the one most recently added.
     * <h4>Notes</h4>
     * <br> - When assembling a multi-stage conversion, it can sometimes be
     * difficult to determine the most economical conversion path. A solution 
     * to this is to include all the steps which are (logically) necessary, 
     * but then to use 
     * astSimplify to simplify the resulting
     * TimeMap. The simplification process will eliminate any steps
     * which turn out not to be needed.
     * <br> - This function does not check to ensure that the sequence of
     * coordinate conversions added to a TimeMap is physically
     * meaningful.
     * <h4>Available Conversions</h4>
     * The following strings (which are case-insensitive) may be supplied
     * via the "cvt" parameter to indicate which time coordinate
     * conversion is to be added to the TimeMap. Where arguments are needed by
     * the conversion, they are listed in parentheses. Values for
     * these arguments should be given, via the "args" array, in the
     * order indicated. Units and argument names are described at the end of 
     * the list of conversions, and "MJD" means Modified Julian Date.
     * <p>
     * <br> - "MJDTOMJD"  (MJDOFF1,MJDOFF2): Convert MJD from one offset to another.
     * <br> - "MJDTOJD"  (MJDOFF,JDOFF): Convert MJD to Julian Date.
     * <br> - "JDTOMJD"  (JDOFF,MJDOFF): Convert Julian Date to MJD.
     * <br> - "MJDTOBEP" (MJDOFF,BEPOFF): Convert MJD to Besselian epoch.
     * <br> - "BEPTOMJD" (BEPOFF,MJDOFF): Convert Besselian epoch to MJD.
     * <br> - "MJDTOJEP" (MJDOFF,JEPOFF): Convert MJD to Julian epoch.
     * <br> - "JEPTOMJD" (JEPOFF,MJDOFF): Convert Julian epoch to MJD.
     * <br> - "TAITOUTC" (MJDOFF): Convert a TAI MJD to a UTC MJD.
     * <br> - "UTCTOTAI" (MJDOFF): Convert a UTC MJD to a TAI MJD.
     * <br> - "TAITOTT"  (MJDOFF): Convert a TAI MJD to a TT MJD.
     * <br> - "TTTOTAI"  (MJDOFF): Convert a TT MJD to a TAI MJD.
     * <br> - "TTTOTDB"  (MJDOFF, CLOCKLON, CLOCKLAT): Convert a TT MJD to a TDB MJD.
     * <br> - "TDBTOTT"  (MJDOFF, CLOCKLON, CLOCKLAT): Convert a TDB MJD to a TT MJD.
     * <br> - "TTTOTCG"  (MJDOFF): Convert a TT MJD to a TCG MJD.
     * <br> - "TCGTOTT"  (MJDOFF): Convert a TCG MJD to a TT MJD.
     * <br> - "TDBTOTCB" (MJDOFF): Convert a TDB MJD to a TCB MJD.
     * <br> - "TCBTOTDB" (MJDOFF): Convert a TCB MJD to a TDB MJD.
     * <br> - "UTTOGMST" (MJDOFF): Convert a UT MJD to a GMST MJD.
     * <br> - "GMSTTOUT" (MJDOFF): Convert a GMST MJD to a UT MJD.
     * <br> - "GMSTTOLMST" (MJDOFF, CLOCKLON, CLOCKLAT): Convert a GMST MJD to a LMST MJD.
     * <br> - "LMSTTOGMST" (MJDOFF, CLOCKLON, CLOCKLAT): Convert a LMST MJD to a GMST MJD.
     * <br> - "LASTTOLMST" (MJDOFF, CLOCKLON, CLOCKLAT): Convert a GMST MJD to a LMST MJD.
     * <br> - "LMSTTOLAST" (MJDOFF, CLOCKLON, CLOCKLAT): Convert a LMST MJD to a GMST MJD.
     * <br> - "UTTOUTC" (DUT1): Convert a UT1 MJD to a UTC MJD.
     * <br> - "UTCTOUT" (DUT1): Convert a UTC MJD to a UT1 MJD.
     * <br> - "LTTOUTC" (LTOFF): Convert a Local Time MJD to a UTC MJD.
     * <br> - "UTCTOLT" (LTOFF): Convert a UTC MJD to a Local Time MJD.
     * <p>
     * The units for the values processed by the above conversions are as
     * follows: 
     * <p>
     * <br> - Julian epochs and offsets: Julian years
     * <br> - Besselian epochs and offsets: Tropical years
     * <br> - Modified Julian Dates and offsets: days
     * <br> - Julian Dates and offsets: days
     * <p>
     * The arguments used in the above conversions are the zero-points 
     * used by the 
     * astTransform function.
     * The axis values supplied and returned by 
     * astTransform 
     * are offsets away from these zero-points:
     * <p>
     * <br> - MJDOFF: The zero-point being used with MJD values.
     * <br> - JDOFF: The zero-point being used with Julian Date values.
     * <br> - BEPOFF: The zero-point being used with Besselian epoch values.
     * <br> - JEPOFF: The zero-point being used with Julian epoch values.
     * <br> - CLOCKLON: Clock longitude in radians (+ve westwards).
     * <br> - CLOCKLAT: Clock geodetic latitude in radians (+ve northwards).
     * <br> - DUT1: The UT1-UTC value to use. 
     * <br> - LTOFF: The offset between Local Time and UTC (in hours, positive 
     * for time zones east of Greenwich).
     * @param   cvt
     * Pointer to a null-terminated string which identifies the
     * time coordinate conversion to be added to the
     * TimeMap. See the "Available Conversions" section for details of
     * those available.
     * 
     * @param   args
     * An array containing argument values for the time
     * coordinate conversion. The number of arguments required, and
     * hence the number of array elements used, depends on the
     * conversion specified (see the "Available Conversions"
     * section). This array is ignored
     * and a NULL pointer may be supplied
     * if no arguments are needed.
     * 
     * @throws  AstException  if an error occurred in the AST library
     */
    public native void timeAdd( String cvt, double[] args );

}
