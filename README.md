meta-micropython
================

OpenEmbedded layer for [MicroPython](https://micropython.org/ "MicroPython"). 

MicroPython is a lean and fast implementation of the Python 3 programming language that is optimised to run on embedded systems.

## Available versions

### MicroPython

 * `1.6`

### MicroPython-lib

 * `1.0`

## Available Packages

 * `micropython`
 * `micropython-native`
 * `micropython-lib`
 * `micropython-lib-native`
 
## Installation
	
Add `meta-micropython` layer to `EXTRALAYERS` in `conf/bblayers.conf`. For example:

	```bitbake
		EXTRALAYERS +=" \
			${TOPDIR}/sources/meta-micropython \
		"
	```
 
Usage
=====

### Building MicroPython Packages

To build latest MicroPython package:

```shell
	bitbake micropython
```

### MicroPython as a dependency

Add MicroPython as a dependency in recipe with `RDEPENDS` (for runtime) or `DEPENDS` (for build):

```bitbake
	DEPENDS += " micropython"
	RDEPENDS_${PN} += " micropython"
```

