[![Build Status](https://travis-ci.org/Hronom/jackson-dataformat-rison.svg?branch=master)](https://travis-ci.org/Hronom/jackson-dataformat-rison)
[![Dependency Status](https://www.versioneye.com/user/projects/56f820c135630e0029db09a9/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56f820c135630e0029db09a9)
[![codecov.io](https://codecov.io/github/Hronom/jackson-dataformat-rison/coverage.svg?branch=master)](https://codecov.io/github/Hronom/jackson-dataformat-rison?branch=master)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://opensource.org/licenses/apache-2.0)
[![Join the chat at https://gitter.im/Hronom/jackson-dataformat-rison](https://badges.gitter.im/Hronom/jackson-dataformat-rison.svg)](https://gitter.im/Hronom/jackson-dataformat-rison?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Rison Parser and Generator for Jackson
======================================

Introduction
-----

Alive version of project [bazaarvoice/rison] (https://github.com/bazaarvoice/rison) that supports
 latest version of Jackson (2.7.x).

This version is a mix of fork [maximaleshko/rison] (https://github.com/maximaleshko/rison) and
solution from issue [Not compatible with latest version of Jackson] (https://github.com/bazaarvoice/rison/issues/5#issuecomment-144750890)
 suggested by user [fakeh] (https://github.com/fakeh)

**This project needs your help! Feel free to contribute!**

Description
-----

A plugin for the [Jackson JSON Processor] (http://wiki.fasterxml.com/JacksonHome)
that adds support for reading and writing JSON objects in the [Rison] (https://github.com/Nanonid/rison)
serialization format.

Rison expresses the exact same data structures as JSON, but is much more compact and readable than
 JSON when encoded in a URI.

See [Rison] (https://github.com/Nanonid/rison) for more information about Rison.

Maven dependency
-----

To use in Maven-based projects, use following dependency:
```xml
<dependency>
    <groupId>com.github.hronom</groupId>
    <artifactId>jackson-dataformat-rison</artifactId>
    <version>2.7.3</version>
</dependency>
```

Usage
-----

In your code, create a `RisonFactory` instead of a `JsonFactory`.  Then read and write objects just
as you do regular JSON objects.  All the Jackson mapper facilities are available with Rison.

```java
import com.github.hronom.jackson.dataformat.rison.RisonFactory;

String string = "(a:0,b:foo,c:'23skidoo')";
Map map = RISON.readValue(string, Map.class);
...
RISON.writeValueAsString(map);
```

O-Rison
-------

If you know the value you wish to serialize is always an object, you can configure the
`RisonFactory` to omit the containing `(` and `)` characters.

```java
ObjectMapper O_RISON = new ObjectMapper(
    new RisonFactory().
    enable(RisonGenerator.Feature.O_RISON).
    enable(RisonParser.Feature.O_RISON));

String string = "a:0,b:foo,c:'23skidoo'";
Map map = O_RISON.readValue(string, Map.class);
...
System.out.println(O_RISON.writeValueAsString(map));
```

A-Rison
-------

If you know the value you wish to serialize is always an array, you can configure the `RisonFactory`
to omit the containing `!(` and `)` characters.

```java
ObjectMapper A_RISON = new ObjectMapper(new RisonFactory().
    enable(RisonGenerator.Feature.A_RISON).
    enable(RisonParser.Feature.A_RISON));

String string = "item1,item2,item3";
List list = A_RISON.readValue(string, List.class);
...
System.out.println(A_RISON.writeValueAsString(list));
```

Other Implementations
---------------------

See the [Rison] (https://github.com/Nanonid/rison) page for implementations in JavaScript, Python
and Ruby.
