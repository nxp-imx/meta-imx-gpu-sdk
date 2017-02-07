#!/bin/sh -e

PROGNAME=$(basename $0)
error_exit() {
	echo "${PROGNAME}: ${1:-"Unknown Error"}" 1>&2
	exit 1
}

if [ -z $BUILDDIR ]; then
    error_exit "\
Environment variable 'BUILDDIR' missing.\n\
Please initialize your build environment."
fi

bblayers=$BUILDDIR/conf/bblayers.conf
if [ ! -f $bblayers ]; then
    error_exit "\
Configuration file '$bblayers' missing.\n\
Please fix your build environment."
fi

echo "BBLAYERS += \"\${BSPDIR}/sources/meta-imx-gpu-sdk\"" >> $bblayers
