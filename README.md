Rison Parser and Generator for Jackson
======================================

A plugin for the [Jackson streaming JSON processor] (http://wiki.fasterxml.com/JacksonHome) that adds
support for reading and writing JSON objects in the [Rison] (http://mjtemplate.org/examples/rison.html)
serialization format.

Rison expresses the exact same data structures as JSON, but is much more compact and readable than JSON
when encoded in a URI.

See http://mjtemplate.org/examples/rison.html for more information about Rison.

Usage
-----

In your code, create a `RisonFactory` instead of a `JsonFactory`.  Then read and write objects just
as you do regular JSON objects.  All the Jackson mapper facilities are available with Rison.

    import com.bazaarvoice.jackson.rison.RisonFactory;
    
    ObjectMapper RISON = new ObjectMapper(new RisonFactory());
    
    String string = "(a:0,b:foo,c:'23skidoo')";
    Map map = RISON.readValue(json, Map.class);
    ...
    RISON.writeValueAsString(map);


O-Rison
-------

If you know the value you wish to serialize is always an object, you can configure the `RisonFactory`
to omit the containing `(` and `)` characters.

    ObjectMapper O_RISON = new ObjectMapper(new RisonFactory().
        configure(RisonGenerator.Feature.O_RISON, true).
        configure(RisonParser.Feature.O_RISON, true));

    String string = "a:0,b:foo,c:'23skidoo'";
    Map map = O_RISON.readValue(json, Map.class);
    ...
    O_RISON.writeValueAsString(map);


A-Rison
-------

If you know the value you wish to serialize is always an array, you can configure the `RisonFactory`
to omit the containing `!(` and `)` characters.

    ObjectMapper A_RISON = new ObjectMapper(new RisonFactory().
        configure(RisonGenerator.Feature.A_RISON, true).
        configure(RisonParser.Feature.A_RISON, true));

    String string = "item1,item2,item3";
    Map map = A_RISON.readValue(json, Map.class);
    ...
    A_RISON.writeValueAsString(map);


Other Implementations
---------------------
See the [Rison] (http://mjtemplate.org/examples/rison.html) page for implementations in JavaScript,
Python and Ruby.