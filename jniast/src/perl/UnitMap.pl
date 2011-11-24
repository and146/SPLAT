#!/usr/bin/perl -w

use strict;

use JMaker;
use SrcReader;

my( $cName ) = "UnitMap";
my( $aName );

print "package uk.ac.starlink.ast;\n\n";

makeClassHeader(
   Name => $cName,
   purpose => ClassPurpose( $cName ),
   descrip => ClassDescrip( $cName ),
   version => '$Id$',
   author => "Mark Taylor (Starlink)",
);

print "public class UnitMap extends Mapping {\n";

makeNativeConstructor(
   Name => $cName,
   purpose => "Creates a $cName.",
   descrip => "",
   params => [
      {
         name => ( $aName = "ncoord" ),
         type => 'int',
         descrip => ArgDescrip( $cName, $aName ),
      },
   ],
);

print "}\n";
