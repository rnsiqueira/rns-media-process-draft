package br.com.rns.process;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;

public class MediaProcess {

    public static void main(String[] args) throws IOException {


        var ffmpeg = new FFmpeg("/usr/bin/ffmpeg");
        var ffprobe = new FFprobe("/usr/bin/ffprobe");

        FFmpegBuilder builder = new FFmpegBuilder()

                .setInput("src/main/resources/media/repo/input/mouseQueen.avi")     // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true) // Override the output if it exists

                .addOutput("src/main/resources/media/repo/output/mouseQueen.mp4")   // Filename for the destination
                .setFormat("mp4")        // Format is inferred from filename, or can be set

//                .disableSubtitle()       // No subtiles
//
//                .setAudioChannels(1)         // Mono audio
//                .setAudioCodec("aac")        // using the aac codec
//                .setAudioSampleRate(48_000)  // at 48KHz
//                .setAudioBitRate(32768)      // at 32 kbit/s
//
//                .setVideoCodec("libx264")     // Video using x264
//                .setVideoFrameRate(24, 1)     // at 24 frames per second
//                .setVideoResolution(640, 480) // at 640x480 resolution
//
//                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

// Run a one-pass encode
        executor.createJob(builder).run();




    }


}