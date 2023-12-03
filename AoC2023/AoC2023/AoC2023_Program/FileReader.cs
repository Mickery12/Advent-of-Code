namespace AoC2023.AoC2023_Program;

public static class FileReader
{
    public static IEnumerable<string> FileContent => File.ReadAllLines(Path.GetFullPath("data.txt"));
}