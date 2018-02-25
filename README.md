# tungtool Eclipse plugin mirror

## Mirror plugins

Build and run a Docker container and call:

http://host:8017/mirror/{app}/{name}?source={source}

app is 'metadata' or 'artifact'.

name is the resulting folder name of the mirrored plugin.

source is the source URL of the plugin update site.

example:
- http://host:8017/mirror/metadata/GRECLIPSE-e4.7?source=http://dist.springsource.org/release/GRECLIPSE/e4.7
- http://host:8017/mirror/artifact/GRECLIPSE-e4.7?source=http://dist.springsource.org/release/GRECLIPSE/e4.7

## Use as local plugin update site

example:
- http://host:8017/GRECLIPSE-e4.7
