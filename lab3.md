A failure inducing input for the original method reverseInPlace is an array of {3,2,1}. 
`@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3, 2, 1 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 1, 2, 3 }, input1);
	}`
 An input that doesn't induce failure would be an array that only contains one object, such as {3}
 `@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}`
![symptom](lab3ExampleFailure.PNG)

`static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }`

`static void reverseInPlace(int[] arr) {
    int temp = 0;
    for(int i = 0; i < arr.length/2; i += 1) {
      temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
  }`

  This fix addresses the issue because the bug was that the previous values of the array were not saved. Thus, by making a temporary variable and simulatneously swapping two positions at once, (and halfing the for loop) the bug was solved.
  
