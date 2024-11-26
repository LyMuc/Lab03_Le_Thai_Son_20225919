public void GarbageCreator {

String filename = "test.exe"; // test.exe is the name or path to an executable file
byte[] inputBytes = { 0 };
long startTime, endTime;

inputBytes = Files.readAllBytes(Paths.get(filename));
startTime = System.currentTimeMillis();
String outputString = "";
for (byte b : inputBytes) {
    outputString += (char) b;
}
endTime = System.currentTimeMillis();
System.out.println(endTime - startTime);

}
