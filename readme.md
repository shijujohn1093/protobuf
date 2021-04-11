IDL(Interface description language) Protobuf sample model creation

/*
1 is tag;  
 tag 1-15 uses only 1 bytes  (frequently used field should use thees range)
 16-2047 uses 2 bytes   (should be used for rest of the fields)
 2047 is not the smallest number you can go till 2 ^ 29 number of fields
 1900 - 19999 are reserved numbers shouldnt be used.
 
*/

/*
ANALYSIS : 
We also need to find out which fields are frequenlty used fields
*/
