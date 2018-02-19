# Easy-java-storage-system-
This is a easy to use java storage system that uses .txt files to work. It will be easy to set up.
#### Important Parts to setup(for those who rush)
1. The storage script is the part that holds system. It cannot be deleted, everything else can. *Tests.java* is just a simple user interface for testing the system.
2. Settinng up file location is as simple as when calling the class *Storage storage = new Storage("data.txt");
3. You can not use the symbols ';' and ':'
##### IMPORTANT
4. YOU **MUST** add some basic text to the Storage file or else the script throws errors: insert something like *doNotDelete~Call:notForUse;*
#### Information for people who want to know more (How it works)
Data saves like: *ID\~Call:Data;ID2\~Call:Data2;ID3~Call:Data3;* The ';' seperate different data strings and the ':' seperate the two parts, call and data.

#### Very detailed setup explanation
Once you download the scripts, put them into a package of your choosing. - the test.java is a simple menu for you to use and test the system out, but is also a simple editor. I recomend you keep it and use it if you dont know how to build your own data editor. Now everything is where you want, time to use it in a script. I have made here a simple class with the implementation done. Obviosly you will have to edit it but take a look. 
###### Use class
package (package);<br />
//above your class package, bellow the system import. (package) is what you put<br />
import (package).Storage;<br />
    <br />
public class Use {<br />
  //get the system<br />
  Storage storage = new Storage("data.txt");<br />
    <br />
  //save data<br />
  storage.write("save/call_id", "data behind id");<br />
    <br />
  //get data<br />
  storage.get("call_id");<br />
    <br />
  //delete data<br />
  storage.delete("call_id");<br />
  }<br />
  <br />
## That should be all to set it up, you can use that and edit it!
