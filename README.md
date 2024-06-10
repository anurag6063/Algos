/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/maximum-depth-of-binary-tree/
[Pattern]: 
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""

"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/

--
 to make a note
// #Note: 

---



git pull
git status
git add *
git commit -m "LL middle"
git push origin


Find all files wil Tips in it - recursively inall sub dir too: 
	grep -r '^\[Tips\]' .

Find all files with Pattern and Tips: 
	grep -r -E '^\[(Pattern|Tips)\]' .

Find all files with Pattern and Tips with spaces and o/p file:
	grep -r -A 1 -E '^\[(Pattern|Tips|Problem)\]' . > notes.txt


Find all files with Pattern and Tips with spaces and o/p file without filename:
	grep -rh -A 1 -E '^\[(Pattern|Tips|Problem)\]' . > notesLink.txt

---

Find all file ending with .java
	find . -type f -name "*.java" | wc -l






DSA Strategy

Do as a list that i derive first, most importantly ABG List currently. 

The list should have related questions, don't do questions randomly initially. 

Revise the list on own the list is what gives me direction. 

At last will also have a list of random questions, when i do interview prep, the list can have other params too like how much confidence i have for this, the pattern involved, revision no etc. 

Always try to find if i can find material to solve such questions first. Study this material for max an hour. 

If material not found, just practice 10 questions and find material as per common pattern and read about it in more detail. 

Find a common pattern and then understand the basic concept first. 

There is always a basic of thing. 

Solve - Unseen question:

Find and go though material if i have any, of same topic. before starting.

Try out the question for 5 mins to 10 mins. 

Draw approach on   - write the steps in it.

now find the solution from chatGPT

if answer un understandable, find a online video for same. 

From the video make notes in the solution - top - of the probable pattern too

write good comment in code. 

Add in solution the reference link to the YT video. 

Check-in the code to Git. 



Add tags like: With HashTag

Pattern : the patter that the code may fall into

Tips: The most important code part of the algo.

Revision: no of times this has been revised.

Confidence: in percentage

Next: What is next to be done about this.

Steps: the steps that were followed

//-----


$sourceFile = "C:\Users\Anura\OneDrive - Pegasystems Inc\Desktop\dustbin\StackQueue\CarsFleet.txt"
$pdfFile = "C:\Users\Anura\OneDrive - Pegasystems Inc\Desktop\dustbin\StackQueue\CarsFleet.pdf"

Start-Process -FilePath "C:\Windows\System32\cmd.exe" -ArgumentList "/c notepad.exe /p `"$sourceFile`"" -Wait
Start-Sleep -Seconds 5

Add-Type -AssemblyName System.Windows.Forms
$printer = [System.Drawing.Printing.PrinterSettings]::InstalledPrinters.Cast([string]) | Where-Object { $_ -eq 'Microsoft Print to PDF' }

if ($printer) {
    $p = New-Object System.Drawing.Printing.PrintDocument
    $p.PrinterSettings.PrinterName = 'Microsoft Print to PDF'
    $p.DefaultPageSettings.Landscape = $false

    $p.PrinterSettings.PrintFileName = $pdfFile
    $p.PrinterSettings.PrintToFile = $true
    $p.PrinterSettings.PrinterName = 'Microsoft Print to PDF'
    $p.Print()
}
else {
    Write-Host "Microsoft Print to PDF printer not found."
}
