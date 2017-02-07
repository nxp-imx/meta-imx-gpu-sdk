SUMMARY = "Tessellation RLE Compressed Image Decoder"
DESCRIPTION = "Provides a decoder for Tesselation RLE Compression, \
a proprietary (patent pending), lossless image compression mechanism \
that takes advantage of high-performance rendering of i.MX 6 and \
above GPUs."
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=08fd295cce89b0a9c74b9b83ed74f671"

inherit fsl-eula-unpack2 fsl-eula-graphics

BBCLASSEXTEND =+ "native nativesdk"

RDEPENDS_${PN}_class-native    = "libpng"
RDEPENDS_${PN}_class-nativesdk = "libpng"
RDEPENDS_${PN}_class-target = " \
    imx-gpu-viv \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', \
       bb.utils.contains('DISTRO_FEATURES',     'x11',  'xrandr', \
                                                              '', d), d)} \
"

SRC_URI[i686-native.md5sum] = "ccb6c5381ff8838ae8abe4c3ed72b270"
SRC_URI[i686-native.sha256sum] = "78fa4af8b0f03e9641398391286ca9f9ab01c23654a778435bbd9f627320e9df"

SRC_URI[i686-nativesdk.md5sum] = "ccb6c5381ff8838ae8abe4c3ed72b270"
SRC_URI[i686-nativesdk.sha256sum] = "78fa4af8b0f03e9641398391286ca9f9ab01c23654a778435bbd9f627320e9df"

SRC_URI[x86_64-native.md5sum] = "150c6f7f833245515c08bd18c28d3bcf"
SRC_URI[x86_64-native.sha256sum] = "0747c2d8c339bd9513ec02c19e99e792ab4566407e6f4de96760126b72def1a8"

SRC_URI[x86_64-nativesdk.md5sum] = "18fc1c86bebe92630a4ec8e6512779db"
SRC_URI[x86_64-nativesdk.sha256sum] = "da458af06037a05d324cf9e94f0c8213fa338a7e80e3465ab01fb36a96d4f9a3"

SRC_URI[arm-fb.md5sum] = "a5b1e052b589ada87bce27babbf44bf3"
SRC_URI[arm-fb.sha256sum] = "76e31e8f997e4cc592ac3b9701b5e104d14e96bb740f7cbd670cb2b4274ced15"

SRC_URI[arm-wayland.md5sum] = "bd1b24c9416d760269e98bcfce2a0c61"
SRC_URI[arm-wayland.sha256sum] = "74df53d994e710b4c60325e885b952c6cfad3b126fc5bd553d2ce5956599b7b5"

SRC_URI[arm-x11.md5sum] = "9d320426f3c1ed07c6891a054d57f748"
SRC_URI[arm-x11.sha256sum] = "1d84e6fb43e007305936ee69922dad8998b81d5527e6372fc609676863098d22"

SRC_URI[aarch64-fb.md5sum] = "1a921f8a65a9275c3b690c3ad843dc31"
SRC_URI[aarch64-fb.sha256sum] = "16bcd7cdb94705ff195edfbe2bb763ab26ea4b7d9603aaafbb4f4fdbf969456e"

SRC_URI[aarch64-wayland.md5sum] = "d34c9a6322206ee6f27621c29e74c822"
SRC_URI[aarch64-wayland.sha256sum] = "ea4da34cdbe5dcc1694789e98807b857a1ef6f132b5db1fc227a7a0950fd7bc4"

SRC_URI[aarch64-x11.md5sum] = "e0c6d880fb40c5f43947fd055fee80ba"
SRC_URI[aarch64-x11.sha256sum] = "fa82957d44744ccce088d8bcc860f1d632b3fb9685c8d3a88181245992ea7fd2"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

# Compatible only with i.MX with 3D hardware
COMPATIBLE_MACHINE                   = "(^$)"
COMPATIBLE_MACHINE_imxgpu3d          = "${MACHINE}"
